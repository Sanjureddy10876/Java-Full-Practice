package com.kodewala.threadpractiseexamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyChallenge {
	public static void main(String[] args) throws InterruptedException {
		AtomicInteger counter = new AtomicInteger(3);
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for(int i =0; i < 3; i++) {
			executorService.submit(()-> {
				for (int j = 0; j < 1000; j++) {
					counter.incrementAndGet();
					
				}
			});
		}
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.SECONDS);
		System.out.println("Final Count" +counter.get());
	}

}
