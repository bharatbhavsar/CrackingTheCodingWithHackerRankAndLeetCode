package linkedList;

import java.util.Scanner;
import java.util.Stack;

public class PalindromCheck {

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
		
		PalindromCheck obj = new PalindromCheck();
		myNode reverse = obj.reverseLinkList(myLink);
		
		System.out.println("Given linked list is Palindrom: (true/ false) :: " + obj.checkPalindrom(myLink, reverse));
		System.out.println("Given linked list is Palindrom: (true/ false) :: " + obj.isItPalindrom(myLink));
		in.close();
	}
	
	myNode reverseLinkList(myNode node){
		if(node==null || node.next == null){
			return node;
		}else{
			myNode temp = new myNode(node.data);
			temp.next = null;
			myNode reverse;
			
			myNode forward = node.next;
			
			while(forward != null){
				reverse = new myNode(forward.data);
				reverse.next = temp;
				forward = forward.next;
				temp = reverse;
			}
			return temp;
		}
	}
	
	boolean checkPalindrom(myNode first, myNode second){
		while(first != null){
			if(first.data != second.data){
				return false;
			}
			first = first.next;
			second = second.next;
		}
		return true;
	}
	
	boolean isItPalindrom(myNode node){
		myNode slow = node;
		myNode fast = node;
		Stack<Integer> myStack = new Stack<Integer>();
		while(fast != null && fast.next != null){
			myStack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null){
			slow = slow.next;
		}
		
		while(slow != null){
			if(myStack.pop().intValue() != slow.data){
				return false;
			}
			slow = slow.next;
		}
		 return true;
	}
}
