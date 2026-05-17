package com.kodewala.threads;

class MyThread extends Thread {
	
	@Override
	public void run() { // run does not return anything
		//work on task
		for (int i = 0; i < 10; i++) {
			System.out.println("Number is "+i+" and...printed by"+ Thread.currentThread().getName());
		}
	}
}

public class ThreadExample {
	public static void main(String[] args) {
		System.out.println("Driver.main()- START "+Thread.currentThread().getName());
		//creating thread object
		MyThread t0 = new MyThread(); // main
		// Starting the thread
		t0.start(); // started new Thread(Thread-0)
		
		MyThread t1 = new MyThread(); // main
		t1.start(); // started new Thread(Thread-1)
		
		System.out.println("Driver.main()- END "+Thread.currentThread().getName());
	}

}
