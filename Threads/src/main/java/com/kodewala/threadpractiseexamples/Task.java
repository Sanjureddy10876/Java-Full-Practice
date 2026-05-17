package com.kodewala.threadpractiseexamples;

import java.util.concurrent.locks.ReentrantLock;

public class Task {
	ReentrantLock reentrantLock = new ReentrantLock();

	synchronized void printEven() throws InterruptedException{
		for (int i = 0; i <= 10; i++) {
			reentrantLock.tryLock();
			if (i % 2 == 0) {
				System.out.println("this is even Numnber " + i + Thread.currentThread().getName());
			}
			reentrantLock.unlock();
		}
	}

	synchronized void printOdd() throws InterruptedException{
		for (int i = 0; i <= 10; i++) {
			reentrantLock.tryLock();
			if (!(i % 2 == 0)) {
				System.out.println("This od Odd numbers " + i + Thread.currentThread().getName());
			}
			reentrantLock.unlock();
		}

	}
}
