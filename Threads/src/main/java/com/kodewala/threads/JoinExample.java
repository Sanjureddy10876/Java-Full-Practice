package com.kodewala.threads;

class cook extends Thread {
	
	@Override
	public void run() {
		try {
			System.out.println("Cooking food - started");
			Thread.sleep(2000);
			System.out.println("Cooking food - end");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
public class JoinExample {
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Waited - Took Order and waiting for food to be cooked");
		Thread.currentThread().setName("Waiter");
		cook c1 = new cook();
		c1.start();
		c1.join();
		System.out.println("Waited - Started serving food");
	}

}
