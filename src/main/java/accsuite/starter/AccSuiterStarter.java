package accsuite.starter;

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
	private String accSuiteBinPath;
	private  String workingDirectoryPath;
	
	final int POOL_ENTITY_COUNT = 5;
	
	
	AccSuiterStarter(String accSuiteBinPath,String workingDirectoryPath) {
		setAccSuiteBinPath(accSuiteBinPath);
		setWorkingDirectoryPath(workingDirectoryPath);
	}
	
	public void startUpload() {
		for (int i = 0; i < POOL_ENTITY_COUNT; ++i) {
			
			Thread runningAccSuiteUpload = new Thread(new AccSuiteRunning(this));
			runningAccSuiteUpload.run();
			
		}
		
	}

	public String getAccSuiteBinPath() {
		return accSuiteBinPath;
	}

	public void setAccSuiteBinPath(String accSuiteBinPath) {
		this.accSuiteBinPath = accSuiteBinPath;
	}

	public String getWorkingDirectoryPath() {
		return workingDirectoryPath;
	}

	public void setWorkingDirectoryPath(String workingDirectoryPath) {
		this.workingDirectoryPath = workingDirectoryPath;
	}
	
}
