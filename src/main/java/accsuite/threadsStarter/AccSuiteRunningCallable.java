package accsuite.threadsStarter;

import java.io.IOException;
import java.util.concurrent.Callable;

import accsuite.core.Package;
import accsuite.main.Global;

public class AccSuiteRunningCallable<T,V> implements Callable<String> {
	
	public AccSuiteRunningCallable() {
		super();
		// TODO Auto-generated constructor stub
	}

	private T keyDescrition;
	private V valueDescrition;

	

	public AccSuiteRunningCallable(T key, V value) {
		keyDescrition = key;
		valueDescrition = value;
	}

	@Override
	public String call() throws Exception {
		String result = "NO";
		Runtime runner = Runtime.getRuntime();
		Process runningProcess = null;
		try {
			String commandString = null;
			Global.println(Thread.currentThread().getName());
			runningProcess = runner.exec(commandString);
			runningProcess.waitFor();		
		}
		catch (IOException | InterruptedException e) {
			e.printStackTrace();
			
		}
		return result;
		
	}

}
