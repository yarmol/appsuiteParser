package accsuite.threadsStarter;

import java.io.IOException;

import accsuite.upload.into.Chunk;

public class AccSuiteRunning implements Runnable {
	public AccSuiteRunning() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Chunk starter;

	

	public AccSuiteRunning(Chunk chunk) {
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

	public Chunk getStarter() {
		return starter;
	}

	public void setStarter(Chunk chunk) {
		this.starter = chunk;
	}

}
