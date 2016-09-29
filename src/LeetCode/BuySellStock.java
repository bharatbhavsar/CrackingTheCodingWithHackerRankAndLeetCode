package LeetCode;

import java.util.Scanner;

public class BuySellStock {

	public static void main(String[] args){
		int[] array;
		Scanner in = new Scanner(System.in);
		array = new int[in.nextInt()];
		for(int i = 0; i < array.length; i++){
			array[i] = in.nextInt();
		}
		BuySellStock obj = new BuySellStock();
		obj.maxProfit(array);
	}
	
	
    public int maxProfit(int[] prices) {
	    int min = 0;
	    int diff = 0;
	    if(prices.length > 1){
	        min = prices[0];
	        for(int i = 0; i < prices.length; i++){
	            if(prices[i] < min){
	                min = prices[i];
	            }
	            if(prices[i] - min > diff){
	                diff = prices[i] - min;
	            }
	        }
	    }
	    return diff;
    }
}
