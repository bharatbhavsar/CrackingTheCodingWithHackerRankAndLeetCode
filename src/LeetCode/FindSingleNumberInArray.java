/**
 * Given an array of integers, every element appears twice except for one. 
 * Find that single one.
 * Note: Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */

package LeetCode;

import java.util.HashMap;

public class FindSingleNumberInArray {

	public static void main(String[] args){
		int[] array = {2,3,4,3,2};
		int[] array3s = {2,3,4,5,4,3,2,2,3,4};
		long start = System.nanoTime();
		System.out.println("Single int in 2's array is: " + singleNumberIn2sSet(array));
		long end = System.nanoTime();
		System.out.println("First way:" + (end-start));
		start = System.nanoTime();
		System.out.println("Single int in 2's array is: " + singleNumberIn2sSetOtherWay(array));
		end = System.nanoTime();
		System.out.println("Second way:" + (end-start));
		System.out.println("Single int in 3's array is: " + singleNumberIn3sSet(array3s));
	}
	
	static int singleNumberIn2sSet(int[] array){
		int x = 0;
		for (int i : array){
			x = x ^ i;
		}
		
		return x;
	}
	
	static int  singleNumberIn2sSetOtherWay(int[] array){
		HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < array.length; i++){
			if(!numMap.containsKey(array[i])){
				numMap.put(array[i], 1);
			}else{
				numMap.put(array[i], numMap.get(array[i]) + 1);
			}
		}
		int res=-1;
		for(Integer i : numMap.keySet()){
			if(numMap.get(i) == 1){
				res=(int)i;
			}
		}
		return res;
	}
	
	public static int singleNumberIn3sSet(int[] A) {
	    int ones = 0, twos = 0, threes = 0;
	    for (int i = 0; i < A.length; i++) {
	        twos |= ones & A[i];
	        ones ^= A[i];
	        threes = ones & twos;
	        ones &= ~threes;
	        twos &= ~threes;
	    }
	    return ones;
	}
}
