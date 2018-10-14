/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

	For example:
	
	    A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28 
 */

package com.LeetCode;

public class ExcelColumnNumberFromColumnTitle {

	public static void main(String[] args){
		System.out.println(titleToNumber("ASD"));
	}
	public static int titleToNumber(String s) {
        
        if(s==null || s.length() == 0){
            throw new IllegalArgumentException("Input is not valid!");
        }
        
        int i = s.length() - 1;
        int result = 0;
        while(i>=0){
            
            result += (int)Math.pow(26,s.length()-i-1) * (s.charAt(i)-'A'+1);
            i--;
        }
        return result;
    }
}
