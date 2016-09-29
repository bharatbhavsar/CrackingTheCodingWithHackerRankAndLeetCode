/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint 
 * stopping you from robbing each of them is that adjacent houses have security 
 * system connected and it will automatically contact the police if two adjacent 
 * houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of 
 * each house, determine the maximum amount of money you can rob tonight without 
 * alerting the police.
 * 
 */

package LeetCode;

public class RobHousesWithMax {

	
	/**
	 * Time complexity = O(n)
	 * where n is size of array.
	 * @param nums
	 * @return
	 */
	public static int maxRob(int[] nums){
		if(nums==null || nums.length==0) return 0;
		
		int sum1=0, sum2=0;
		
		for(int i=0; i<nums.length;i++){
			if(i%2==0){
				sum1 += nums[i];
				sum1 = sum1 > sum2 ? sum1 : sum2;
			}else{
				sum2 += nums[i];
				sum2 = sum1 > sum2 ? sum1 : sum2;
			}
		}
		
		return sum1 > sum2 ? sum1 : sum2;
	}
	
	/**
	 * This is time consuming and with extra space too
	 * Time complexity is still O(n)
	 * but space complexity is also n
	 * 
	 * @param nums
	 * @return
	 */
	public static int maxRobMemo(int[] nums){
		if(nums==null || nums.length ==0) return 0;
		
		if(nums.length==1){
			return nums[0];
		}
		int[] dp = new int[nums.length];
		dp[0]=nums[0];
		dp[1]=Math.max(nums[0], nums[1]);
		
		for(int i=2; i<nums.length; i++){
			dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
		}
		return dp[nums.length-1];
	}
}
