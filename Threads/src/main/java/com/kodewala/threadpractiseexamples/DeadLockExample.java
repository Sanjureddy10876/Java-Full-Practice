package com.kodewala.threadpractiseexamples;

class Abc implements Runnable{

	Object lock1;
	Object lock2;
	
	
	
	public Abc(Object lock1, Object lock2) {
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
				System.out.println("thread 2::locked:::");
			}
			
		}
	}
	
}

class Def implements Runnable{

	Object lock1;
	Object lock2;
	
	
	public Def(Object lock1, Object lock2) {
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
				System.out.println("thread 1:: locked:::");
			}
			
		}
		
	}
	
}


public class DeadLockExample {
	public static void main(String[] args) {
		System.out.println(" Dead lock is started:::");
		Object lock1 = new Object();
		Object lock2 = new Object();
		
		Thread t1 = new Thread(new Abc(lock1,lock2));
		Thread t2 = new Thread(new Def(lock1,lock2));
		
		t1.start();
		t2.start();
	
		System.out.println(" Dead lock is ended:::");
		
	}

}
