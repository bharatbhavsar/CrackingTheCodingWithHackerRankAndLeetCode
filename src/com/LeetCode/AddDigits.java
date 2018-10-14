/**
 * Given a non-negative integer num, repeatedly add all its digits 
 * until the result has only one digit. 
 * 
 * For example: 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it.
 *
 */
package com.LeetCode;
public class AddDigits {
	public static void main(String[] args){
		int b = 54;
		System.out.println("Digit addition for number is: " + addDigits(b));
	}
	public static int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return (Math.abs(num) - 1) % 9 + 1;
    }
}
