package accsuite.starter;

import java.io.IOException;

public class AccSuiteRunning implements Runnable {
	public AccSuiteRunning() {
		super();
		// TODO Auto-generated constructor stub
	}

	private AccSuiterStarter starter;

	

	public AccSuiteRunning(AccSuiterStarter starterParams) {
		setStarter(starterParams);
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

	public AccSuiterStarter getStarter() {
		return starter;
	}

	public void setStarter(AccSuiterStarter starter) {
		this.starter = starter;
	}

}
