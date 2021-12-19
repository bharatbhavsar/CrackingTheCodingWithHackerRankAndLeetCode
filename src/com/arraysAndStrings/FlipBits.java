package com.arraysAndStrings;

public class FlipBits {
	
	public static void main (String[] args){
		System.out.println(flipBinary(10));
	}
	
	public static long flipBinary(long n){
		
		StringBuilder binary = new StringBuilder(Long.toBinaryString(n));
		while(binary.length()<32){
			binary.insert(0, 0);
		}
		
		for(int i=0; i<32; i++){
            char j = binary.charAt(i)=='0'?'1':'0';
            binary.setCharAt(i,j);
        }
		
		return Long.parseLong(binary.toString(), 2);
	}

}
