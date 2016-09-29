/**
 * Given an array of size n, find the majority element. The majority element is the element 
 * that appears more than  |_ n/2 _|   times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 */


package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FindMejorityElement {

	public static void main(String[] args){
		
	}
	/**
	 * This is fast solution.
	 * No extra space. Nice one.
	 * But Time complexity is same n*(log n) due to Arrays.sort().
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {

        if (nums.length == 1) {
    		return nums[0];
    	}
     
    	Arrays.sort(nums);
    	return nums[nums.length / 2];
    }
	
	/**
	 * This is SLOW solution with extra space complexity too.
	 * Time complexity is same but takes extra time to store and later on access
	 * HashMap elements with comparison computation.
	 * Simple.
	 * 
	 * @param nums
	 * @return
	 */
	public static int majorityElementSlow(int[] nums){
		HashMap<Integer, Integer> myNums = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(!myNums.containsKey(nums[i])){
                myNums.put(nums[i], 1);
            }else{
                myNums.put(nums[i], myNums.get(nums[i])+1);
            }
        }
        Set<Integer> mySet = myNums.keySet();
        Iterator<Integer> i = mySet.iterator();
        int result=-1;
        while(i.hasNext()){
            Integer j = i.next();
            if(myNums.get(j)>(nums.length)/2){
                result = j.intValue();
                break;
            }
        }
        return result;
        
	}
}
