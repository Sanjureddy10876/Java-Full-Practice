package com.kodewala.strings.examples;

public class IndustryExperienceExamples {
	public static void main(String[] args) {
		String str = "santhosh";
		
		// Commonly used to validate user input, like checking if a password
		// meets minimum length requirements
		str.length();
		
		// Used to compare Strings in Apis, lie verifying user-names
		// or search keywords
		str.equals(str);
		str.equalsIgnoreCase(str);
		
		// Useful when appending fixed Strings to form file-paths or dynamic messages
		str.concat(str);
		
		// Used in data data extraction task like parsing account numbers or substrings from logs
		str.substring(3);
		
		// Frequently used for standardizing user input (eg. email normalization).
		str.toUpperCase();
		str.toLowerCase();
	}

}
