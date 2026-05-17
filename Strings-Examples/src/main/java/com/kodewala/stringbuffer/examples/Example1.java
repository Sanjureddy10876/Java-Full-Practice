package com.kodewala.stringbuffer.examples;

public class Example1 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Hello");
		
		//capacity formula :: New Capacity = (Current Capacity * 2) + 2
		System.out.println(sb.capacity());
		sb.append(" world");
		sb.append(" from santhosh Reddy");
		
		System.out.println(sb);
		
		sb.insert(5, " Mining");
		System.out.println(sb);
		System.out.println(sb.capacity());
	}
}
