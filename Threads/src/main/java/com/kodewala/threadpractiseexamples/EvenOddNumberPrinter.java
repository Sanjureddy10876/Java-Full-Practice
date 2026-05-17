package com.kodewala.threadpractiseexamples;

class Even extends Thread {
	@Override
	public void run() {
	for (int i = 0; i < 30; i++) {
		synchronized (Even.class) {
			if (i % 2==0) {
				 System.out.println(i);
			}	
		}
		
	}
	}
}

class Odd extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			synchronized (Odd.class) {
				if (!(i% 2==0)) {
					System.out.println(i);
				}
			}
		 	
		}
	}
}

public class EvenOddNumberPrinter {
	public static void main(String[] args) {
		
		Even t0 = new Even();
		Odd t1 = new Odd();
		
		t0.start();
		t1.start();
	}

}
