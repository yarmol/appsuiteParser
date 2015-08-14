package accsuite.threadsStarter;

import java.io.IOException;

import accsuite.core.Package;

public class AccSuiteRunning implements Runnable {
	public AccSuiteRunning() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Package starter;

	

	public AccSuiteRunning(Package chunk) {
		setStarter(chunk);
	}

	public void run()  {
			String commandString = "";
			Runtime runner = Runtime.getRuntime();
			Process runningProcess = null;
			try {
				runningProcess = runner.exec(commandString);
				runningProcess.waitFor();		
			}
			catch (IOException | InterruptedException e) {
				e.printStackTrace();
				
			}
			

	}

	public Package getStarter() {
		return starter;
	}

	public void setStarter(Package chunk) {
		this.starter = chunk;
	}

}
