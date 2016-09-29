/**
 * Given an array of integers, every element appears twice except for one. 
 * Find that single one.
 * Note: Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */

package LeetCode;

public class FindSingleNumberInArray {

	public static void main(String[] args){
		int[] array = {2,3,4,3,2};
		int[] array3s = {2,3,4,5,4,3,2,2,3,4};
		System.out.println("Single int in 2's array is: " + singleNumberIn2sSet(array));
		System.out.println("Single int in 3's array is: " + singleNumberIn3sSet(array3s));
	}
	
	static int singleNumberIn2sSet(int[] array){
		int x = 0;
		for (int i : array){
			x = x ^ i;
		}
		
		return x;
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
