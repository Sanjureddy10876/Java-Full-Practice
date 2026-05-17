package com.kodewala.threads;

public class RaceConditionSolution {

	public static void main(String[] args) {
		Task12 task12 = new Task12();
		
		EvenThread t0 = new EvenThread(task12);
		OddThread t1 = new OddThread(task12);
		
		t0.start();
		t1.start();
	}
}
