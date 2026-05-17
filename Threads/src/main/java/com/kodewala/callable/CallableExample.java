package com.kodewala.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyThread implements Callable<String>{
	
	@Override
	public String call() throws Exception {
		int sum = 10+30;
		return "Helllo from call()";
	}
}

public class CallableExample {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		MyThread t0 = new MyThread();
		Future<String> future = executorService.submit(t0);
		String msg=future.get();
		System.out.println(msg);
		executorService.shutdown();
		
		
	}

}
