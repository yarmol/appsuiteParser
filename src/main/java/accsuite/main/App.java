package accsuite.main;

import java.io.IOException;
import java.util.List;

import accsuite.*;
import accsuite.core.DoProcess;
import accsuite.core.Package;

/**
 * 
 * Class App.
 * Class to initialize batch of 1c acc.applications 
 * to upload dt/cf file and dump them into special catalog.
 * Stages:
 *  - Parameters to start application:
 *  	- 1cstart.exe path
 *  	- git path
 *  	- working directory (temp bases will be created here)
 *  	- directory to analize
 *  - Analizing directory (by date) of dt/cf files (using few threads),
 *    uploading cf or dt file into temporary bases located in working directory.
 *    
 *  - Create pool of threads to unload .conf files from every deployed temporary db
 *  - Create root directory of .conf files with git repo.
 *  - Day-by-day add .conf files into repo:
 *      - creating new branch, checkout, add, commit (as old date), merge with master.
 *  - Analize final .git repo with all dump history of project.
 *  
 *  	 
 *  
 *   
 * @author vitaly
 * @date 12 ���. 2015 �.
 */


public class App {
	
	

	public static void start(String[] args) throws IOException {
		
		// setting up global values
		
		Global.setAccSuiteBinPath(args[0]);
		Global.setAnalizingDir(args[3]);
		Global.setGitBinPath(args[1]);
		Global.setWorkingDir(args[2]);
		Global.setNumberOfThreads(5);
		
		//running first stage: UPLOAD TO ACC.SUITE BASES

		DoProcess.start();
		

	}

}
