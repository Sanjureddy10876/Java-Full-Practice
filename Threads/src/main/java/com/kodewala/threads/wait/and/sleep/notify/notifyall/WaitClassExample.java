package com.kodewala.threads.wait.and.sleep.notify.notifyall;

class Task{
	
	
	synchronized void printnumber() throws InterruptedException {
		for(int i=0; i< 10; i++) {
			System.out.println("Task.dosomeThing()"+Thread.currentThread().getName());
			Thread.sleep(500);// t0 is holding object lock of task object
			wait(100); // will release object lock and goes to waiting state
		}
	}
}

class MyThread extends Thread {
	
	private Task task;
	
	public MyThread(Task _Task) {
		this.task=_Task;
	}
	
	@Override
	public void run() {
		try {
			task.printnumber();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


public class WaitClassExample {
	public static void main(String[] args) {
		MyThread t0 = new MyThread(new Task());
		t0.start();
		
	}
}
