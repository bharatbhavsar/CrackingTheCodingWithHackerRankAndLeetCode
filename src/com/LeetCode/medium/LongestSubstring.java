package com.LeetCode.medium;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Given a string s, find the length of the longest substring without repeating characters.
 *  

Example:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.


Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.


Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

 * 
 */

public class LongestSubstring {
	public static int lengthOfLongestSubstring(String s) {
        int maxSubString = 0;
        
        for(int i = 0; i < s.length(); i ++){
            Set<Character> myCharSet = new HashSet<Character>();
            for(int j = i; j < s.length(); j++){
                if (!myCharSet.contains(s.charAt(j))){
                    myCharSet.add(s.charAt(j));
                    if(j == s.length() - 1){
                        if(myCharSet.size() > maxSubString){
                            maxSubString = myCharSet.size();
                        }
                    }
                }else{
                    if(myCharSet.size() > maxSubString){
                        maxSubString = myCharSet.size();
                    }
                    break;
                }
            }
        }
        return maxSubString;
    }
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the string: \n");
		
		String s = in.nextLine();
		in.close();
		
		System.out.println("Maximum length of unique character substring: " + lengthOfLongestSubstring(s));
		
	}

}
