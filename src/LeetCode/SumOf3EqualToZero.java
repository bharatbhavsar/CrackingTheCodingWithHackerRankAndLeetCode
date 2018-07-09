/**
 * Given an array S of n integers, are there elements a, b, c in S such that 
 * a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * 			A solution set is:
  			[
			  [-1, 0, 1],
			  [-1, -1, 2]
			]
*/

package LeetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOf3EqualToZero {

	public static void main(String[] args){
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println("Given Array: " + Arrays.toString(nums));
		System.out.println("Result: "+threeSum(nums));
	}
	public static List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
 
        if(nums == null || nums.length<3)
            return result;
 
        Arrays.sort(nums);
     
        for(int i=0; i<nums.length-2; i++){
            if(i==0 || nums[i] > nums[i-1]){
                int j=i+1;
                int k=nums.length-1;
     
                while(j<k){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);
     
                        j++;
                        k--;
     
                        //handle duplicate here
                        while(j<k && nums[j]==nums[j-1])
                            j++;
                        while(j<k && nums[k]==nums[k+1])
                            k--;
     
                    }else if(nums[i]+nums[j]+nums[k]<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }
        }
 
        return result;
    }
}

/**
 * Following Algo is also correct but it is greedy and has TimeComplexity is O(n^3)
 * Above one is better with time compexity of
 * O( nlogn + n^2) in worst case
 *  
 	public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<Set<Integer>> mySet = new HashSet<Set<Integer>>();
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    if((nums[i]+nums[j]+nums[k])==0){
                        Set<Integer> temp1 = new HashSet<Integer>();
                        temp1.add(nums[i]);
                        temp1.add(nums[j]);
                        temp1.add(nums[k]);
                        if(!mySet.contains(temp1)){
                            mySet.add(temp1);
                            List<Integer> temp = new ArrayList<Integer>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            result.add(temp);
                        }
                    }
                }
            }
        }
        return result;
    }
 
 * 
 */
