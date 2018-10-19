/**
 * Given a string of 0s, 1s and *s(wildcard character),generate a string of matching patterns
 * For example: if given String is: 10*0*1 then matching strings are: 101011, 101001, 100001, 100011 
 */

package com.dynamicPrograming;

public class MatchPattern {
	public static void main(String[] args){
		matchingPatternStrings("10*0*1");;
	}
	
	static void matchingPatternStrings(String s){
		matchingPatternStrings(s,0);
	}
	
	static void matchingPatternStrings(String s, int i){
		if(i == s.length()){
			System.out.println(s);
			return;
		}
		if(s.charAt(i) == '*'){
			String t = s.substring(0, i) + "0" + s.substring(i+1);
			matchingPatternStrings(t, i+1);
			String u = s.substring(0, i) + "1" + s.substring(i+1);
			matchingPatternStrings(u, i+1);
		}else{
			matchingPatternStrings(s, i+1);
		}
	}
}
