package com.kodewala.stringbuffer.examples;

public class HomeWorkTask {

	public static void main(String[] args) {
		StringBuffer sb =  new StringBuffer();
		sb.append("1. Buy groceries");
		sb.append(" 2. Finish homework");
		sb.append(" 3. Call the plumber");
		
		sb.insert(35, " Updated");
//		sb.delete(34, 38);
		System.out.println(sb);
		
	}
}
