package com.linkedList;

import java.util.Scanner;

public class SumReverseStored {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of digits in first number: ");
		int num1 = in.nextInt();
		System.out.println("Enter digits in reverse order: ");
		int firstNum1 = in.nextInt();
		
		myNode myLink1 = new myNode(firstNum1);
		for(int i =0; i < num1 -1; ++i){
			myLink1.append(in.nextInt());
		}
		
		System.out.println("Enter number of digits in second number: ");
		int num2 = in.nextInt();
		System.out.println("Enter digits in reverse order: ");
		int firstNum2 = in.nextInt();
		
		myNode myLink2 = new myNode(firstNum2);
		for(int i =0; i < num2 -1; ++i){
			myLink2.append(in.nextInt());
		}
		
		SumReverseStored obj = new SumReverseStored();
		myNode result = obj.mySum(myLink1, myLink2, 0);
		while(result!=null){
			System.out.print(result.data + " ->");
			result = result.next;
		}
		in.close();
	}
	
	myNode mySum(myNode first, myNode second, int carry){
		if(first == null && second == null && carry == 0){
			return null;
		}
		
		myNode result = new myNode();
		
		int value = carry;
		if(first != null){
			value +=first.data;
		}
		if(second != null){
			value +=second.data;
		}
		
		result.data = value % 10;
		if(first != null || second != null){
			myNode next = mySum(first == null ? null : first.next, 
								second == null ? null : second.next, 
								value >= 10 ? 1 : 0);
			result.next = next;
		}
		return result;
	}
}
