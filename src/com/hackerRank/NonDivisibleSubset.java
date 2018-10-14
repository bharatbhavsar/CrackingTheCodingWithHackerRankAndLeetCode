/**
 * Given a set, S, of n distinct integers, print the size of a maximal subset, S', of S where 
 * the sum of any 2 numbers in S' are not evenly divisible by k.

	Input Format
	The first line contains 2 space-separated integers, n and k, respectively. 
	The second line contains n space-separated integers (we'll refer to the ith  value as a[i] )
	describing the unique values of the set.
	
	Sample Input

	4 3
	1 7 2 4
	
	Sample Output
	
	3
	
	HackerRankLink: https://www.hackerrank.com/challenges/non-divisible-subset
 */

package com.hackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NonDivisibleSubset {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int sizeOfArray = in.nextInt();
        int divider = in.nextInt();
        Map<Integer, Integer> remainders = new HashMap<>();
		for(int i = 0; i < sizeOfArray; i++) {
			int remainder = in.nextInt() % divider;
			remainders.compute(remainder, (key, value) -> (value == null || key == 0) ? 1 : (value + 1));
		}
        int noOfElementsInSubset = remainders.getOrDefault(0, 0);
		int i = 1;
		for(; 2 * i < divider; i++) {
			noOfElementsInSubset += Math.max(remainders.getOrDefault(i, 0), remainders.getOrDefault(divider - i, 0));
		}
        
        if(2 * i == divider) {
			noOfElementsInSubset++;
		}
		
		System.out.println(noOfElementsInSubset);
        
    }
}
