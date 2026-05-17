package com.kodewala.threads;

public class EvenThread extends Thread{
	
	Task12 task12;
	
	

	public EvenThread(Task12 task12) {
		super();
		this.task12 = task12;
	}



	@Override
	public void run() {
		task12.even();
	}

}
