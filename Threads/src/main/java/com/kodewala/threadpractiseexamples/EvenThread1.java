package com.kodewala.threadpractiseexamples;

public class EvenThread1 extends Thread{
	Task task;
	
	
	public EvenThread1(Task task) {
		super();
		this.task = task;
	}


	@Override
	public void run() {
		
		try {
			task.printEven();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
