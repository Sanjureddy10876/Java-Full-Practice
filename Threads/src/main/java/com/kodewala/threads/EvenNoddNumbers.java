package com.kodewala.threads;

class MyEvenNumber extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
		if ( i % 2!=0) {
			System.out.println("This Numbers is EvenNumbers "+i+" "+Thread.currentThread().getName());
		}
		else {
			System.out.println("This Number is not EvenNumbers "+i+" "+Thread.currentThread().getName());
		}
		}
	}
}

class MyOddNumber extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if ( i % 2==0) {
				System.out.println("This Numbers is oddNumbers "+i+" "+Thread.currentThread().getName());
			}
			else {
				System.out.println("This Number is not oddNumbers "+i+" "+Thread.currentThread().getName());
			}
		}
		
	}
}
public class EvenNoddNumbers {
	public static void main(String[] args) {
		
		MyEvenNumber t0 = new MyEvenNumber(); 
		
		t0.start();
		
		MyOddNumber t1 = new MyOddNumber(); 
		t1.start();
		
	}

}
