/*
 The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"

Example 2:

Input: 4
Output: "1211"
 */
package com.LeetCode;

public class CountAndSay {

	public static void main(String[] args){
		int n = 7;
		String prev;
        int intCount = 1;
        String currentInt = "1";
        for(int i = 1; i <= n; i++){
            StringBuilder current = new StringBuilder();
            if(i==1){
                
                current.append("1");
                currentInt = current.toString();
                
            }else{
                prev = currentInt;
                
                for(int j = 0; j < prev.length(); ++j){
                    if((j+1) != prev.length() && prev.charAt(j+1) == prev.charAt(j)){
                        intCount++;
                    }else{
                        current.append(intCount);
                        current.append(prev.charAt(j));
                        intCount=1;
                    }
                }
                
                currentInt = current.toString();
                
            }
            
        }
        System.out.println(currentInt);;
    }
	
}
