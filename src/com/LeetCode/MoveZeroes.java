/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining 
 * the relative order of the non-zero elements.

	For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
	nums should be [1, 3, 12, 0, 0].

	Note:
	You must do this in-place without making a copy of the array.
	Minimize the total number of operations.
 */

package com.LeetCode;

public class MoveZeroes {

	public static void main(String[] args){
		int[] array = {0,0,0,0,0,1,2,3,5,4};
		moveZeroes(array);
		for(int i : array)
			System.out.print(i+" ");
	}
	public static void moveZeroes(int[] nums) {
        if(nums.length>1){
            int i=0;
            while(nums[i]!=0 && i<nums.length-1){
                i++;
            }
            if(i<nums.length-1){
                for(int j =i+1; j<nums.length; j++){
                    if(nums[j]!=0){
                        int temp = nums[j];
                        nums[j]=nums[i];
                        nums[i]=temp;
                        i++;
                    }
                }    
            }
        }
    }
}
