/**
 * 	Given a sorted array, remove the duplicates in place such that each element appear 
 * 	only once and return the new length.

	Do not allocate extra space for another array, you must do this in place with constant memory.
	
	For example,
	Given input array nums = [1,1,2],
	
	Your function should return length = 2, with the first two elements of nums being 1 and 2 
	respectively. It doesn't matter what you leave beyond the new length.
 */

package com.LeetCode;

public class RemoveDuplicateFromSortedArray {

	public static int removeDuplicates(int[] A) {
        if (A.length < 2)
		    return A.length;
 
    	int j = 0;
    	int i = 1;
     
    	while (i < A.length) {
    		if (A[i] == A[j]) {
    			i++;
    		} else {
    			j++;
    			A[j] = A[i];
    			i++;
    		}
    	}
     
    	return j + 1;
    }
}
