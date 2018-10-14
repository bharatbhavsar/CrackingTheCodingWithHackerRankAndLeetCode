/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 *
 *	The digits are stored such that the most significant digit is at the head of the list.
 */
package com.LeetCode;


import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumberArray {
	public static void main(String[] args){
		int[] number = {9,9,9,9};
		int[] returnNumber = plusOne(number);
		int[] returnNumber2 = plusOne2(number);
		for(int i : returnNumber){
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i : returnNumber2){
			System.out.print(i+" ");
		}
	}
	public static int[] plusOne(int[] digits) {
        ArrayList<Integer> resNumber = new ArrayList<Integer>();
        int carry = 1;
        for(int i = digits.length-1; i>=0; i--){
            int mod = (digits[i]+carry)%10;
            resNumber.add(0, mod);;
            carry = (digits[i]+carry)/10;
        }
        if(carry == 1){
            resNumber.add(0,1);
        }
        int[] result = new int[resNumber.size()];
        
        for(int i = 0; i< result.length; i++){
        	result[i]=resNumber.get(i).intValue();
        }
        return result;
    }
	
	public static int[] plusOne2(int[] digits) {
        int[] result = new int[digits.length+1];
        int carry = 1;
        for(int i = digits.length-1; i>=0; i--){
            int mod = (digits[i]+carry)%10;
            result[i+1]=mod;
            carry = (digits[i]+carry)/10;
        }
        if(carry == 1){
            result[0]=1;
        }
        if(result[0]==1){
        	return result;
        }else{
        	return Arrays.copyOfRange(result, 1, result.length);
        }
    }
}
