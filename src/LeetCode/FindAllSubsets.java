/**
 * 	Given a set of distinct integers, nums, return all possible subsets.

	Note: The solution set must not contain duplicate subsets.

	For example,
	If nums = [1,2,3], a solution is:

	[
  		[3],
  		[1],
  		[2],
  		[1,2,3],
  		[1,3],
  		[2,3],
  		[1,2],
  		[]
	]
	
 */

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllSubsets {

	public static void main(String[] args){
		int[] nums = {1,2,3,4};
		for(List<Integer> result : allSubSets(nums)){
			System.out.println(result);
		}
		
	}
	
	static List<List<Integer>> allSubSets(int[] nums){
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(nums == null){
			return result;
		}
		
		Arrays.sort(nums);
		
		
		
		for(int i = 0; i < nums.length; i++){
			List<List<Integer>> temp = new ArrayList<List<Integer>>();
			
			for(List<Integer> list : result){
				temp.add(new ArrayList<Integer>(list));
			}
			
			for(List<Integer> list : temp){
				list.add(nums[i]);
			}
			
			List<Integer> single = new ArrayList<Integer>();
			single.add(nums[i]);
			temp.add(single);
			
			result.addAll(temp);
			
		}
		
		result.add(new ArrayList<Integer>());
		
		return result;
	}
	
}
