/**
 * HackerRank problem link:
 * https://www.hackerrank.com/challenges/sherlock-and-squares
 */

package com.hackerRank;

public class PerfectSqrInGivenRange {

	public static void main(String[] args){
		long start=25, end=120;
		System.out.println(perfectSqrCount(start, end));
	}
	
	public static int perfectSqrCount(long str, long end){
		int res =0;
		long s = (long)Math.sqrt(str);
		if(s*s!=str){
			s++;
		}
		for(long j=s; j*j<=end; j++){
			res++;
		}
		return res;
	}
}
