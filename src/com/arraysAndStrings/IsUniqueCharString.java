package com.arraysAndStrings;

public class IsUniqueCharString {
	
	public boolean isUniqueWithStorage(String s){
		if(s.length() > 128){
			return false;
		}
		boolean[] chars = new boolean[128];
		for(int i=0; i<s.length(); i++){
			if(chars[(int)s.charAt(i)]){
				return false;
			}
			chars[(int)s.charAt(i)] = true;
		}
		return true;
	}
	
	public static void main(String[] args){
		String s = "Isth";
		IsUniqueCharString myObj = new IsUniqueCharString();
		System.out.println("Is it Unique?: " + myObj.isUniqueWithStorage(s));
	}

}
