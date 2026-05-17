package com.kodewala.threadpractiseexamples;

//Question:
//Create two threads:
//
//Thread 1 prints numbers from 1 to 10
//Thread 2 prints numbers from 11 to 20
//
//👉 Ensure both run concurrently.
class f1 extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
		System.out.println("printing numbers "+i+ Thread.currentThread().getName());	
		}
	}
}
class f2 extends Thread {
	
	@Override
	public void run() {
		for (int i = 11; i < 20; i++) {
			System.out.println("printing numbers "+i+ Thread.currentThread().getName());	
		}
	}
}

public class RunParellely {
	public static void main(String[] args) {
		f1 t0 = new f1();
		f2 t1 = new f2();
		
		t0.start();
		t1.start();
	
	}

}
