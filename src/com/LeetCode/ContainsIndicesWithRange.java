/**
 * Given an array of integers, find out whether there are two distinct indices i and j 
 * in the array 
 * such that the difference between nums[i] and nums[j] is at most t 
 * and the difference between i and j is at most k.
 */

package com.LeetCode;

import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsIndicesWithRange {

	public static void main(String[] args){
		int[] array = {1,2,3,4,5,6,7,8,9};
		int indexRange = 2;
		int valueRange = 0;
		System.out.println("This set contains Indices with given range: " + ifContains(array, indexRange, valueRange));
	}
	
	static boolean ifContains(int[] array, int indexRange, int valueRange){
		if(array == null || array.length < 2 || indexRange < 0 || valueRange < 0){
			return false;
		}
		
		TreeSet<Long> mySet = new TreeSet<Long>();
		
		for(int i = 0; i < array.length; i++){
			long current = (long)array[i];
			
			long leftBound = current - valueRange;
			long rightBound = current + valueRange + 1; //to include rightBound in range as subSet return value excluding right bound.
			
			// mySet.subSet() returns sorted subset from leftBound(included) to 
			// rightBound(excluded).
			SortedSet<Long> subSet = mySet.subSet(leftBound, rightBound); 
			
			if(subSet.size()>0){
				return true;
			}
			
			mySet.add(current);
			
			if(i>=indexRange){
				mySet.remove((long)array[i-indexRange]);
			}
		}
		
		return false;
	}
}
