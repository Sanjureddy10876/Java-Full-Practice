package com.kodewala.threads;

public class OddThread extends Thread{

	Task12 task12;
	
	

	public OddThread(Task12 task12) {
		super();
		this.task12 = task12;
	}

	
	@Override
	public void run() {
		task12.odd();
	}
}
