package accsuite.threadsStarter;

import java.util.List;

import accsuite.core.Package;
import accsuite.main.Global;

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
	private List<Package> listOfChunks;
	
	

	
	
	public AccSuiterStarter(List<Package> listOfChunks) {
			this.listOfChunks = listOfChunks;
	}
	
	public void startUpload() {
		
		for (int i = 0; i < Global.getNumberOfThreads(); ++i) {
			
			Thread runningAccSuiteUpload = new Thread(new AccSuiteRunning(listOfChunks.get(i)));
			runningAccSuiteUpload.run();
			
			
		}
		
	}

	
	
}
