/*
 * https://www.hackerrank.com/challenges/java-stack/problem
 */

package com.arraysAndStrings;

import java.util.*;

public class IsParanthesisBalanced {

	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            while(input.length() != (input = input.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length());
            // input = input.replaceAll("\\(\\)|\\[\\]|\\{\\}", "");
            // System.out.println(input);
            System.out.println(!(input.length()>0));
		}
		
		sc.close();
		
	}
}
