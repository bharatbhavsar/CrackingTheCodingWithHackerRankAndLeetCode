package com.arraysAndStrings;
import java.util.*;
public class IsPermutation {

	public static void main (String[] args){
		String s1 = "rohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohan";
		String s2 = "rohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohanrohan";
		System.out.println("Result:" + inPermutation(s1, s2));
		System.out.println("Result:" + isPermutation(s1, s2));
	}
	
	static boolean inPermutation(String s1, String s2){
		
		long start = System.currentTimeMillis();
		if (s1.length() != s2.length()) return false;
		
		Map<Character, Integer> mp = new HashMap<Character, Integer>();
		
		for(int i=0; i<s1.length(); i++){
			if(!mp.containsKey(s1.charAt(i))){
				mp.put((Character) s1.charAt(i), (Integer) 1);
			}else{
				mp.put((Character)s1.charAt(i), mp.get((Character)s1.charAt(i)) + (Integer)1);
			}
		}
		for(int i=0; i<s2.length(); i++){
			if(!mp.containsKey((Character)s2.charAt(i))) {
				long end = System.currentTimeMillis();
				System.out.println("total time in ms with HashMap: " + (end - start));
				return false;
			}else{
				mp.put((Character)s2.charAt(i), mp.get((Character)s2.charAt(i)) - (Integer)1);
				if (mp.get((Character)s2.charAt(i)) < (Integer)0) {
					long end = System.currentTimeMillis();
					System.out.println("total time in ms with HashMap: " + (end - start));
					return false;
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("total time in ms with HashMap: " + (end - start));
		return true;
	}
	
	static boolean isPermutation(String s1, String s2){
		long start =System.currentTimeMillis();
		char[] s1Char = s1.toCharArray();
		char[] s2Char = s2.toCharArray();
		
		Arrays.sort(s1Char);
		Arrays.sort(s2Char);
		if(!Arrays.toString(s1Char).equals(Arrays.toString(s2Char))){
			System.out.println("total time in ms with sort: " + (System.currentTimeMillis()- start));
			return false;
		}
		System.out.println("total time in ms with sort: " + (System.currentTimeMillis()- start));
		return true;
	}
}
