package com.kodewala.threads;

import java.util.concurrent.locks.ReentrantLock;

public class Task12 {
	ReentrantLock reentrantLock = new ReentrantLock();
	 void even() {
		for (int i = 0; i <10; i++) {
			synchronized (Task12.class) {
				System.out.println("Your on Even Syncronized block");
				if (i % 2==0) {
					System.out.println("Even Numbers "+i+""+" "+"Thread name "+Thread.currentThread().getName());
				}
				
			}
			
		
		}
	}

	 void odd() {
		for (int i = 0; i <10; i++) {
			synchronized (Task12.class) {
				System.out.println("Your on Odd Syncronized Block");
				if (i % 2!=0) {
					System.out.println("Even Numbers "+i+""+" "+"Thread name "+Thread.currentThread().getName());
				}
			}
			
			
		}
	}
	
	
}
