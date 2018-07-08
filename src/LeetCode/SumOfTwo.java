/**
 
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 
 */

package LeetCode;

import java.util.HashMap;

public class SumOfTwo {
	
	public static void main(String[] args){
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] res = twoSum(nums, target);
		System.out.println(res[0]+" "+ res[1]);
	}
	
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i =0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])) return new int[] {hm.get(target-nums[i]),i};
            hm.put(nums[i],i);
        }
        return null;
    }
}
