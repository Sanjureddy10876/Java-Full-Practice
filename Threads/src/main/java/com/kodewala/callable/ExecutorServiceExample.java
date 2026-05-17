package com.kodewala.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Task26 implements Callable<String>{
	
	@Override
	public String call() throws Exception {
		
		return "The task number "+"taskNo"+"has been completed by "+Thread.currentThread().getName();
	}
}

public class ExecutorServiceExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		ExecutorService executorService = Executors.newCachedThreadPool(); cpu decides how many threads needed
//		ExecutorService executorService = Executors.newSingleThreadExecutor(); only one thread is created and used
//		ExecutorService executorService = Executors.newFixedThreadPool(10); we can give the count so that it can create the number of threads you iven 
		ExecutorService executorService = Executors.newSingleThreadExecutor(); 
		for (int i = 1; i < 20; i++) {
			Task26 task26 = new Task26();
			Future<String> future = executorService.submit(task26);
			String output = future.get();
			System.out.println(output);
		}
		executorService.shutdown();
	}
}
