package com.LeetCode.medium;
/*
 * 
 LeetCode link: https://leetcode.com/problems/reverse-integer/
 
 Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 
 Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 
 Example 1:

Input: x = 123
Output: 321

Example 2:

Input: x = -123
Output: -321

Example 3:

Input: x = 120
Output: 21

Constraints:

-231 <= x <= 231 - 1
 
 
 * 
 * 
 */
import java.util.Scanner;

public class ReverseInt {
	public static int reverse_fast(int x) {
        long finalNum = 0;
        while(x!=0){
            int lastDig = x%10;
            finalNum += lastDig;
            finalNum = finalNum*10;
            x= x/10;
        }
        finalNum = finalNum/10;
        if(finalNum > Integer.MAX_VALUE || finalNum<Integer.MIN_VALUE){
            return 0;
        }
        if(x<0){
            return (int)(-1*finalNum);
        }
        return (int)finalNum;
    }
	
	public static int reverse_bruforce(int x) {
        String s;
        if(x<0){
            s = String.valueOf(x).substring(1);
        }else{
            s = String.valueOf(x);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        if(x<0){
            sb.insert(0,'-');
        }
        long res = Long.valueOf(sb.toString());
        if(res > Integer.MAX_VALUE || res<Integer.MIN_VALUE){
            return 0;
        }
        return (int)res;
    }
	
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the string: \n");
		
		long s = Long.valueOf(in.nextLine());
		in.close();
		
		System.out.println("Reversed Int fast: " + reverse_fast((int)s));
		System.out.println("Reversed int brutforce: " + reverse_bruforce((int)s));
		
    }
}
