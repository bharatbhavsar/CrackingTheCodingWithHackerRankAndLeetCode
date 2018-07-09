package LeetCode;

import java.util.Scanner;

public class SumWithoutArithmaticOperator {

	public static void main(String[] args){
		int a, b;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 2 number: ");
		a = in.nextInt();
		b = in.nextInt();
		System.out.println("The sum is: " + add(a,b));
		in.close();
	}
	
	static int add(int a, int b){
		int carry;
		int i = 1;
		while(b != 0){
			carry = a & b;
			a = a ^ b;
			b = carry << 1;
			System.out.println("After pass#"+ (i++) +":: a:"+a+" b:"+b+" carry:"+carry);
		}
		return a;
	}
}
