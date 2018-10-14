/**
 * HackerRank problem statement link:
 * https://www.hackerrank.com/challenges/maxsubarray
 */

package com.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSubarray {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i=0; i<testCases; i++){
            int arraySize = in.nextInt();
            int[] arr = new int[arraySize];
            for(int j=0; j<arraySize; j++){
                arr[j] = in.nextInt();
            }
            maxSubArray(arr);
        }
    }
    
    static void maxSubArray(int[] arr){
        int max_ending_here = 0;
        int max_so_far = Integer.MIN_VALUE;
        
        for(int x : arr){
            max_ending_here = Math.max(x, max_ending_here + x);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        System.out.print(max_so_far);
        
        Arrays.sort(arr);
        int sum = 0;
        if(arr[arr.length-1] <= 0){
            sum = arr[arr.length - 1];
        }else{
            for(int x : arr){
                if(x > 0)
                    sum += x;
            }
        }
        
        System.out.println(" " + sum);
    }
}
