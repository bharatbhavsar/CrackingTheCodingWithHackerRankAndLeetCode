/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 *
 *	The digits are stored such that the most significant digit is at the head of the list.
 */
package LeetCode;


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
        ArrayList<Integer> returnNumber = new ArrayList<Integer>();
        int carry = 1;
        for(int i = digits.length-1; i>=0; i--){
            int mod = (digits[i]+carry)%10;
            returnNumber.add(0, mod);;
            carry = (digits[i]+carry)/10;
        }
        if(carry == 1){
            returnNumber.add(0,1);
        }
        int[] result = new int[returnNumber.size()];
        
        for(int i = 0; i< result.length; i++){
        	result[i]=returnNumber.get(i).intValue();
        }
        return result;
    }
	
	public static int[] plusOne2(int[] digits) {
        int[] returnNumber = new int[digits.length+1];
        int carry = 1;
        for(int i = digits.length-1; i>=0; i--){
            int mod = (digits[i]+carry)%10;
            returnNumber[i+1]=mod;
            carry = (digits[i]+carry)/10;
        }
        if(carry == 1){
            returnNumber[0]=1;
        }
        if(returnNumber[0]==1){
        	return returnNumber;
        }else{
        	return Arrays.copyOfRange(returnNumber, 1, returnNumber.length);
        }
    }
}
