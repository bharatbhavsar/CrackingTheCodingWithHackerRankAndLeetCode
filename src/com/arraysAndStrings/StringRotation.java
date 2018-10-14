package com.arraysAndStrings;
import java.util.Scanner;

public class StringRotation {

	public static void main(String[] args){
		String s1, s2;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter first string:");
		s1 = in.nextLine();
		System.out.println("\nEnter second string:");
		s2 = in.nextLine();
		
		int len = s1.length();
		if(len == s2.length() && len > 0){
			String s1s1 = s1 + s1;
			System.out.println("\nIs String rotated? (true/ false): " + s1s1.contains(s2));
		}else{
			System.out.println("\nGiven Strings are not same in length!");
		}
	}
}
