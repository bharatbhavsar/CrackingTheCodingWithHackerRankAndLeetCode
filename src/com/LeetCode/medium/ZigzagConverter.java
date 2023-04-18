package com.LeetCode.medium;

/*
 * Leetcode problem link: https://leetcode.com/problems/zigzag-conversion/
 * 
 * 
 
 
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 
 P   A   H   N
 A P L S I I G
 Y   I   R

 
 And then read line by line: "PAHNAPLSIIGYIR"
 
 Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000

 */

import java.util.*;

public class ZigzagConverter {
	public static String convert_fast(String s, int numRows) {
        int n = s.length();
        if(n == 1 || numRows == 1 || numRows >= n) return s;
        StringBuffer res = new StringBuffer("");
        int diff1 = 2*(numRows - 1);
        int diff2 = 0;
        for(int i = 0; i<numRows; i++){
            int curr = i;
            boolean fst = true;
            while(curr < n){
                res.append(s.charAt(curr));
                if(fst && diff1 != 0 || !fst && diff2 == 0){
                    fst = !fst;
                    curr += diff1;
                } else {
                    fst = !fst;
                    curr += diff2;
                }
            }
            diff1 -= 2;
            diff2 += 2;
        }
        return res.toString();
    }
	
	public static String convert_brutforce(String s, int numRows) {
        boolean down = true;
        ArrayList<StringBuilder> myList = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++){
            myList.add(new StringBuilder());
        }
        int j = 0;
        int secondRow, secondLast;
        if(numRows > 2){
            secondLast = numRows - 2;
            secondRow = 1;
        }else if(numRows == 2){
            secondLast = 0;
            secondRow =1;
        }else{
            secondLast = 0;
            secondRow = 0;
        }
        for(int i = 0; i < s.length(); i++){
            if(down){
                myList.get(j).append(s.charAt(i));
                j++;
                if(j == numRows){
                    j = secondLast;
                    down = false;
                }
            }else{
                myList.get(j).append(s.charAt(i));
                j--;
                if(j < 0){
                    j=secondRow;
                    down = true;
                }
            }
        }
//        for(int i = 0; i < myList.size(); i++){
//            System.out.println(myList.get(i).toString());
//        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < myList.size(); i++){
            res.append(myList.get(i).toString());
        }
        return res.toString();
    }
	
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the string: \n");
		
		String s = in.nextLine();
		in.close();
		
		System.out.println("Zigzag converted string: " + convert_fast(s,3));
		System.out.println("Zigzag converted string: " + convert_brutforce(s,3));
		
    }
}
