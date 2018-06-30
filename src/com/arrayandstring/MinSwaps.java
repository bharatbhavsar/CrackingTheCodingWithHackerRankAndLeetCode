package com.arrayandstring;

public class MinSwaps {
	public static void main(String[] args){
		int[] arr = {4,3,1,2};
		System.out.println(minimumSwaps(arr));
	}
	
	static int minimumSwaps(int[] a){
		int swap = 0;
		for(int i = 0; i < a.length; i++){
			if(i+1 != a[i]){
				int t = i;
				while(a[t]!=i+1){
					t++;
				}
				int temp = a[i];
				a[i] = a[t];
				a[t] = temp;
				swap++;
			}
		}
		return swap;
	}
}
