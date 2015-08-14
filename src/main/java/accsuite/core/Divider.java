package accsuite.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import accsuite.main.Constants;
import accsuite.main.Global;

public class Divider {
	Map<FileDescriptor, String> internalMap;
	int chunkCount;
	
	public Divider(Map<FileDescriptor, String> fileAndCommandMap) {
		internalMap 	= fileAndCommandMap;
		double preValueDouble = (double)(internalMap.size() / Global.getNumberOfThreads());
		int	   preValueInt = (int)(internalMap.size() / Global.getNumberOfThreads());
	
		
		if ((int)preValueDouble == preValueInt) {
			this.chunkCount = preValueInt;
		}
		else {
			this.chunkCount = ++preValueInt;
		}
		
	}

	public ArrayList<Package> getChunks() {
		
		Set<FileDescriptor> setKeys = internalMap.keySet();
	
		FileDescriptor[] descFiles  = (FileDescriptor[]) setKeys.toArray();
		
		
		boolean isContinue = true;
		int arrayIdx 	   = 0;
		int threadLimit    = Global.getNumberOfThreads();
	
		Package activeChunk = null;
		
		ArrayList<Package> resultChunks = new ArrayList<>();
		
		while (isContinue) {
			if (arrayIdx >= descFiles.length) {
				isContinue = false;
				continue;
			}
			
			if ((arrayIdx == 0) || (((arrayIdx+1) % threadLimit) == 1)) {
				activeChunk = new Package();
			}
			else if (((arrayIdx+1) % threadLimit) == 0) {
				//store active chunk
				resultChunks.add(activeChunk);
				
			}
			
			activeChunk.add(descFiles[arrayIdx], internalMap.get(descFiles[arrayIdx]));
			++arrayIdx;
		}
		
		
		
		
		
		
		
		return resultChunks;
	}

}