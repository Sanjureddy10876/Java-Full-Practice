package com.kodewala.strings.examples;

public class Example2 {
	public static void main(String[] args) {

		String str = "santhosh,reddy,mining,karimnagar";
		String[] lang = str.split(",");

		for (String res : lang) {
			System.out.println(res);
		}
		
		String str1 = "kodewala acedamy";
		System.out.println(str1.contains("kodewala"));
		
		System.out.println(str1.startsWith("kod"));
		System.out.println(str1.endsWith("acedamy"));
		
	}
}
