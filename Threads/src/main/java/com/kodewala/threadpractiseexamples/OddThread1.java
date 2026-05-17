package com.kodewala.threadpractiseexamples;

public class OddThread1 extends Thread{
	
	Task task;
	

	public OddThread1(Task task) {
		super();
		this.task = task;
	}


	@Override
	public void run() {
		try {
			task.printOdd();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

