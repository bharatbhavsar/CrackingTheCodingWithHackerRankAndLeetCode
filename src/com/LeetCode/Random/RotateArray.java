/*
 * Given an integer array nums, 
 * rotate the array to the right by k steps, where k is non-negative.
 * 
 * Link:
 * 
 * https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
 */

package com.LeetCode.Random;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateArray {
	
	public static void rotate(int[] nums, int k) {
        if(nums.length < 2 || k == nums.length){
            return;
        }
        if(k > nums.length){
            k = k % nums.length;
        }
            
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = nums.length - k; i < nums.length; i++){
            res.add(nums[i]);
        }
        for(int i = 0; i < nums.length-k; i++){
            res.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = (int)res.get(i);
        }
    }
	
	public static void rotateFast(int[] nums, int k) {
        if(nums.length < 2 || k == nums.length){
            return;
        }
        if(k > nums.length){
            k = k % nums.length;
        }
            
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
	
	public static void reverse(int[] arr, int start, int end) {
		while(start<end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		rotate(nums, k);
		System.out.println(Arrays.toString(nums));
		int[] nums2 = {1,2,3,4,5,6,7};
		rotateFast(nums2, k);
		System.out.println(Arrays.toString(nums));
	}

}
