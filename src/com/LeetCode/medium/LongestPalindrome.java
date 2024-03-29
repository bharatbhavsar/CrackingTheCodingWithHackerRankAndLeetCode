package com.LeetCode.medium;


/*
 * 
 * Given a string s, return the longest palindromic substring in s.
 * 
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.

Leetcode Link: https://leetcode.com/problems/longest-palindromic-substring/description/

 * 
 */

import java.util.Scanner;

public class LongestPalindrome {
	public static String longestPalindrome(String s) {
        int start=0, end=0;
        for(int i = 0; i < s.length(); i++){
            int odd = palindrome(s,i,i);
            int even = palindrome(s,i,i+1);
            int len = Math.max(odd, even);

            if(len > (end - start)){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    } 

    public static int palindrome(String str, int start, int end){
        while(start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }
    
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the string: \n");
		
		String s = in.nextLine();
		in.close();
		
		System.out.println("Longest substring which is palindrome: " + longestPalindrome(s));
		
    }

}
