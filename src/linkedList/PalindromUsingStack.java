package linkedList;

import java.util.Scanner;
import java.util.Stack;

public class PalindromUsingStack {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of items: ");
		int num = in.nextInt();
		System.out.println("Enter data: ");
		int first = in.nextInt();
		
		myNode myLink = new myNode(first);
		for(int i = 0; i < num -1; ++i){
			myLink.append(in.nextInt());
		}
		
		PalindromUsingStack obj = new PalindromUsingStack();
		
		System.out.println("Given linked list is Palindrom: (true/ false) :: " + obj.isPalindrom(myLink));
		in.close();
	}
	
	boolean isPalindrom(myNode myLink){
		myNode fast = myLink;
		myNode slow = myLink;
		
		Stack<Integer> myStack = new Stack<Integer>();
		
		while(fast != null && fast.next != null){
			myStack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast!=null){
			slow = slow.next;
		}
		
		while(slow != null){
			int top = myStack.pop().intValue();
			
			if(top != slow.data){
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
}
