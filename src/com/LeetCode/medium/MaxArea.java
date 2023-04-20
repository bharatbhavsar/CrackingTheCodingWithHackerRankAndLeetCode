package com.LeetCode.medium;

/*
 * 
 * 
 
 Link: https://leetcode.com/problems/container-with-most-water/
 
 You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice: that you may not slant the container.

example:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
In this case, the max area of water (blue section) the container can contain is 49.
 
 * 
 */

public class MaxArea {
	public static int maxArea(int[] height) {
        int maxCap = 0;
        int start = 0;
        int end = height.length - 1;
        while(start < end){
            int min = Math.min(height[start], height[end]);
            int dist = end - start;
            int capacity = dist * min;
            maxCap = Math.max(maxCap, capacity);
            if(height[start] < height[end]){
                start++;
            }else if(height[start] > height[end]){
                end--;
            }else{
                start++;
                end--;
            }
        }
        return maxCap;
    }
	
	public static void main(String[] args) {
//    	Scanner in = new Scanner(System.in);
//		
//		System.out.println("Please enter the string: \n");
//		
//		String s = in.nextLine();
//		in.close();
		
		int[] input = {2,3,1,4,6,8,2,3,1,8,9,2,4};
		
		System.out.println("Max area is: " + maxArea(input));
		
		
    }
}
