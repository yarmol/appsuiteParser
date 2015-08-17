package accsuite.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import accsuite.main.Constants;
import accsuite.main.Global;

public class Divider<T,V> {
	Map<T, V> internalMap;
	int chunkCount;
	
	public Divider(Map<T, V> fileAndCommandMap) {
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

	public ArrayList<Package<T,V>> getPackages() {
		
		List<T> listKeys = new LinkedList<>(internalMap.keySet());
	
			
		boolean isContinue = true;
		int arrayIdx 	   = 0;
		int threadLimit    = Global.getNumberOfThreads();
	
		Package<T,V> activePackage = null;
		
		ArrayList<Package<T,V>> resultPackages = new ArrayList<>();
		int counter = 0;
		while (isContinue) {
			if (arrayIdx >= listKeys.size()) {
				isContinue = false;
				continue;
			}
			
			if ((arrayIdx == 0) || (((arrayIdx+1) % threadLimit) == 1)) {
				activePackage = new Package<>(counter);
				++counter;
			}
			else if (((arrayIdx+1) % threadLimit) == 0) {
				//store active chunk
				
				resultPackages.add(activePackage);
				
			}
			
			T key   = listKeys.get(arrayIdx);
			V value = internalMap.get(key);
			
			activePackage.add(key,value);
			
			++arrayIdx;
		}
		
		
		
		
		
		
		
		return resultPackages;
	}

}
