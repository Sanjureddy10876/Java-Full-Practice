package com.kodewala.threads;


class Task {

	//Runnable
	//method is created here
	void doTask() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " Thread Name " + Thread.currentThread().getName());
		}
	}
}
// implements the Runnable and to call the run mentod
class MyThread1 implements Runnable {

	// calling a class
	Task task;

	// constructor is created using class name
	public MyThread1(Task task) {
		super();
		this.task = task;
	}
	

	//run method is calling another operation
	@Override
	public void run() {
		//Running state
		System.out.println("This is from myThread class" + "And Thread name is : " + Thread.currentThread().getName());
		task.doTask(); // Ones this operation is done The Thread will move to Dead State
	}

}

public class RunnableExample {
	public static void main(String[] args) {
		Task task = new Task(); // new object is created
		MyThread1 myThread = new MyThread1(task);
		Thread t0 = new Thread(myThread);// new Thread is created

		t0.start(); // Runnable state
		Thread t1 = new Thread(myThread); // new Thread is created
		t1.start(); // Runnable state
	}

}
