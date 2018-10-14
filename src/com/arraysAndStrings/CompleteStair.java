package com.arraysAndStrings;

public class CompleteStair {

	public static void main(String[] args){
		System.out.println(arrangeCoins(9999999999999L));
	}
	static void arrangeCoins(long[] array){
	    for(long number : array){
	        System.out.println(arrangeCoins(number));
	    }
	}

	static long arrangeCoins(long number){
		//(-1+sqroot(1+4*2*number))/2
		
		long result = (long)(-1 + Math.sqrt(1+ 4*2 * number)) / 2;
		return result;
	}
}
