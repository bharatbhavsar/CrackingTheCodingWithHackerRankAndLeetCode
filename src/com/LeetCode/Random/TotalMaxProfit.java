package com.LeetCode.Random;

public class TotalMaxProfit {
	
	public int maxProfitFast(int[] prices) {
        int prof = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i]>prices[i-1]){
                prof += prices[i]-prices[i-1];
            }
        }
        return prof;   
    }
	
	public int maxProfit(int[] prices) {
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
