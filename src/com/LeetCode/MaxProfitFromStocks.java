/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many 
 * transactions as you like (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * 
 * 
 */

package com.LeetCode;

public class MaxProfitFromStocks {

	public static void main(String[] args){
		int[] stocks = {7,8,2,5,6,9,8,2,1,4,5,6,3,1,7,5,8,9,5};
		int profit = maxProfit(stocks);
		System.out.println(profit);
	}
	static public int maxProfit(int[] prices) {
        int i=0, j=0;
        int prof=0;
        while(j<prices.length){
            if(j<prices.length-1 && prices[j+1]>prices[j]){
                j++;
            }else if(i<j){
                prof+=prices[j]-prices[i];
                i=j+1;
                j=i;
            }else{
                j++;
                i=j;
            }
        }
        return prof;
    }
}
