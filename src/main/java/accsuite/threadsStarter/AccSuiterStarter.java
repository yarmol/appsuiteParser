package accsuite.threadsStarter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

public class AccSuiterStarter<T,V>  {
	private List<Package<T,V>> listOfChunks;
	
	

	
	
	public AccSuiterStarter(List<Package<T,V>> listOfChunks) {
			this.listOfChunks = listOfChunks;
	}
	
	public void startUpload() throws InterruptedException, ExecutionException {
		
		Iterator<Package<T, V>> packageIterator = listOfChunks.iterator(); 
		while (packageIterator.hasNext()) {
			Package<T,V> actualPackage = packageIterator.next();
			ExecutorService executor = Executors.newFixedThreadPool(Global.getNumberOfThreads());
			
			List<Future<String>> setFutureResults = new ArrayList<>();
			List<String> setResults = new ArrayList<>();
			
			for (T key : actualPackage.getContentMap().keySet()) {
				 V value = actualPackage.getContentMap().get(key);
				
				 AccSuiteRunningCallable<T,V> task = new AccSuiteRunningCallable<>(key,value);
				 Future<String> futureResult =  executor.submit(task);
				 setFutureResults.add(futureResult);		 
			}
			
			for (Future<String> currentFuture : setFutureResults) {
				String batchResult = currentFuture.get();
				setResults.add(batchResult);
			}
			
			
			
			
		}
			
		
	}

	
	
}
