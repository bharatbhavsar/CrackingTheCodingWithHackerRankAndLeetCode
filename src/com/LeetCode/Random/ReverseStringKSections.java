package com.LeetCode.Random;

/*
 * 
 Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

 

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104

 * 
 */

public class ReverseStringKSections {
	public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<s.length()){
            int rev = i;
            int j = 0;
            while(j<k){
                if(i>=s.length())
                    break;
                sb.insert(rev, s.charAt(i));
                j++;
                i++;
            }
            while(j>0){
                if(i>=s.length())
                    break;
                sb.append(s.charAt(i));
                j--;
                i++;
            }
        }
        return sb.toString();
    }

}
