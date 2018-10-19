package com.dynamicPrograming;

import java.util.Arrays;

public class NBitString {
	static int[] A;
	public static void main(String[] args){
		A = new int[10];
		binary(10);
	}
	
	static void binary(int n){
		if(n<1){
			System.out.println(Arrays.toString(A));
		}else{
			A[n-1] = 0;
			binary(n-1);
			A[n-1] = 1;
			binary(n-1);
		}
	}
}
