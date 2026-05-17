package com.kodewala.threadpractiseexamples;

public class Example1 {
	public static void main(String[] args) {
		Task task = new Task();
		
		EvenThread1 t0 = new EvenThread1(task);
		OddThread1 t1 = new OddThread1(task);
	t0.start();
	t1.start();
	}

}
