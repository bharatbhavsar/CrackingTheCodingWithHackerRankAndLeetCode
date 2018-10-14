/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

	For example:
	
	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB
 */


package com.LeetCode;

public class ExcelColumnTitleFromColumnNumber {

	public static void main(String[] args){
		System.out.println(convertToTitle(1174));
		
	}
	
	public static String convertToTitle(int n) {
        if(n<=0){
            throw new IllegalArgumentException("Invalid input!");
        }
        
        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            char c = (char)(n%26 + 'A');
            n/=26;
            result.append(c);
        }
        result.reverse();
        return result.toString();
    }
}
