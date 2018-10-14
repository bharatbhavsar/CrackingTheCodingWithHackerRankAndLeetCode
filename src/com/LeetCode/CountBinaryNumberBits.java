/**
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 <= i <= num calculate the number of 1's 
 * in their binary representation and return them as an array.
 * 
 * Example: 
 * For num = 5 you should return [0,1,1,2,1,2].
 */

package com.LeetCode;

public class CountBinaryNumberBits {

	public static void main(String[] args){
		int a = 15;
		int[] result = countBits(a);
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i]+" ");
		}
		
	}
	
	static int[] countBits(int num){
		int[] result = new int[num + 1];
		
		int pow = 1;
		int p = 1;
		
		for(int i = 1; i < result.length; i++){
			if(i == pow){
				result[i] = 1;
				pow <<= 1;
				p = 1;
			}else{
				result[i] = result[p] + 1;
				p++;
			}
		}
		
		return result;
	}
}
