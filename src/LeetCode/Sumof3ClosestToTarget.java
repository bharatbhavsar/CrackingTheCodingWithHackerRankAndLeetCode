/**
 * Given an array S of n integers, find three integers in S such that 
 * the sum is closest to a given number, target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * LeetCode Link:
 * https://leetcode.com/problems/3sum-closest/
 */

package LeetCode;

import java.util.Arrays;

public class Sumof3ClosestToTarget {
	
	public static void main(String[] args){
		int[] nums = {-3,5,9,-4,8,-2,4};
		System.out.println(threeSumClosest(nums, 5));
	}
	public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int[] values = new int[3];
        Arrays.sort(nums);
        int result = 0;
        
        for(int i=0; i<nums.length; i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                int diff = Math.abs(sum-target);
                
                if(diff==0){
                	values[0]=nums[i];
                	values[1]=nums[j];
                	values[2]=nums[k];
                	for(int l: values){
                    	System.out.println(l);
                    }
                	return sum;
                }
                if(diff<min){
                    min=diff;
                    values[0]=nums[i];
                	values[1]=nums[j];
                	values[2]=nums[k];
                    result=sum;
                }
                if(sum<=target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        for(int i: values){
        	System.out.println(i);
        }
        return result;
    }

}
