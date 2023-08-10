/*
 * Link
 * 
 * https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 */

package com.LeetCode.Random;

public class CanCompleteCircuit {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int total = 0, curr = 0, start = 0;
		
		for(int i = 0; i < gas.length; i++) {
			total += gas[i] - cost[i];
			curr += gas[i] - cost[i];
			
			if(curr < 0) {
				start = i+1;
				curr = 0;
			}
		}
		return total >= 0 ? start : -1;
	}
	
	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		
		System.out.println(canCompleteCircuit(gas,cost));
	}
}
