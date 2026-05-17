package com.kodewala.threadpractiseexamples;

class Reg implements Runnable{
	Object lock1;
	Object lock2;


	public Reg(Object lock1, Object lock2) {
		super();
		this.lock1 = lock1;
		this.lock2 = lock2;
	}


	@Override
	public void run() {
		synchronized (lock1) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (lock2) {
				
			}
		}
		
	}
}

class Bag implements Runnable{
	Object lock1;
	Object lock2;
	
	
	
	public Bag(Object lock1, Object lock2) {
		super();
		this.lock1 = lock1;
		this.lock2 = lock2;
	}



	@Override
	public void run() {
		synchronized (lock2) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (lock1) {
				System.out.println("Thread2 Locked:::");
			}
		}
		
	}
}

public class DeadLock2 {
	public static void main(String[] args) {
		System.out.println("Dead Lock Started");
		Object lock1 = new Object();
		Object lock2 = new Object();
		
		Thread t1 = new Thread(new Reg(lock1, lock2));
		Thread t2 = new Thread(new Bag(lock1, lock2));
		
		t1.start();
		t2.start();
		System.out.println("Dead Lock Ended");
		
	}

}
