package com.LeetCode.medium;

import java.util.Scanner;

/*
 * 
 * 
 Link: https://leetcode.com/problems/palindrome-number/
 
 Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 * 
 */

public class PalindromeNumber {
	public static boolean isPalindrome_bitfast(int x) {
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length() - 1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
	
	public static boolean isPalindrome_normal(int x) {
        String s = String.valueOf(x);
        String r = new StringBuilder(s).reverse().toString();
        if(s.equals(r)){
            return true;
        }else{
            return false;
        }
    }
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the string: \n");
		
		String s = in.nextLine();
		in.close();
		
		System.out.println("Is it Palindrome integer: " + isPalindrome_bitfast(Integer.valueOf(s)));
		System.out.println("Is it Palindrome integer: " + isPalindrome_normal(Integer.valueOf(s)));
		
	}
}
