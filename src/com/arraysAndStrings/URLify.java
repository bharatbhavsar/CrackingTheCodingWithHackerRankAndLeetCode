package com.arraysAndStrings;
import java.util.Scanner;

public class URLify {
	
	public static void main(String[] args){
		String s;
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("Please enter the line: ");
		s = in.nextLine();
		
		
		s = spaceReplacer(s);
		System.out.println("\n NewString: \n" + s);
	}
	
	
	static String spaceReplacer(String s){
		StringBuilder newString = new StringBuilder();
		s = s.trim();
		
		for(int i=0; i< s.length();++i){
			if(s.charAt(i)== ' '){
				newString.append("%20");
			}
			else{
				newString.append(s.charAt(i));
			}
		}
		
		return newString.toString();
	}

}
