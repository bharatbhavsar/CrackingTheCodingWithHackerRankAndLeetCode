/*
 
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]

 */

package com.LeetCode;

import java.util.Scanner;

public class BuySellStockCoolDown {

	public static void main(String[] args){
		int[] array;
		Scanner in = new Scanner(System.in);
		array = new int[in.nextInt()];
		for(int i = 0; i < array.length; i++){
			array[i] = in.nextInt();
		}
		BuySellStock obj = new BuySellStock();
		System.out.println(obj.maxProfit(array));
		in.close();
	}
	
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
  
        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;

        for(int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0; 
            s2 = s1; 
            s1 = s0; 
        }
        return s0;
    }
}
