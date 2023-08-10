/*
 * Link:
 * 
 * https://leetcode.com/problems/roman-to-integer/submissions/1016229218/?envType=study-plan-v2&envId=top-interview-150
 * 
 */

package com.LeetCode.Random;

public class RomanInteger {
	public static int romanToInt(String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}
	
	
}
