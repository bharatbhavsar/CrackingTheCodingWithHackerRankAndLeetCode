/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 
 * into nums1 as one sorted array.

	Note:
	You may assume that nums1 has enough space (size that is greater or equal to m + n) to 
	hold additional elements from nums2. The number of elements initialized in nums1 and nums2 
	are m and n respectively.
 */

package com.LeetCode;

public class MergeSortedArray {

	public static void main(String[] args){
		
	}
	public static void arrayMerger(int[] array1, int size1, int[] array2, int size2){
		while(size1>0 && size2>0){
			if(array1[size1-1]>array2[size2-1]){
				array1[size1+size2-1] =array1[size1-1];
				size1--;
			}else{
				array1[size1+size2-1] =array2[size2-1];
				size2--;
			}
		}
		if(size1>0){
			while(size1>0){
				array1[size1+size2-1] =array1[size1-1];
				size1--;
			}
		}
		if(size2>0){
			while(size2>0){
				array1[size1+size2-1] =array2[size2-1];
				size2--;
			}
		}
	}
}
