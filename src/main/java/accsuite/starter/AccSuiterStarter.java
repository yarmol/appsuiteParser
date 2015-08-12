package accsuite.starter;

import java.util.List;

import accsuite.main.Global;
import accsuite.upload.into.Chunk;

/**
 * 
 * Class AccSuiterStarter.
 * Object to start pool of threads to upload dump files
 * 
 * 
 * @author vitaly
 * @date 12 рту. 2015 у.
 */

public class AccSuiterStarter  {
	private List<Chunk> listOfChunks;
	
	

	
	
	AccSuiterStarter(List<Chunk> listOfChunks) {
			this.listOfChunks = listOfChunks;
	}
	
	public void startUpload() {
		
		for (int i = 0; i < Global.getNumberOfThreads(); ++i) {
			
			Thread runningAccSuiteUpload = new Thread(new AccSuiteRunning(listOfChunks.get(i)));
			runningAccSuiteUpload.run();
			
		}
		
	}

	
	
}
