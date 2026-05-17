package com.kodewala.strings.examples;

public class Example3 {
	
	public static void main(String[] args) {
		
		String str = "Mining";
		
		System.out.println(str.length());
		char[] arr = str.toCharArray();
		
		for(char res: arr) {
//			System.out.print(res);
		}
		
		String str1= "Santhosh";
		String str2 = "Mining";
		System.out.println(str1+str2);
		System.out.println(str1.concat(str2));
	}

}
