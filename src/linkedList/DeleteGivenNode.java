package linkedList;

import java.util.Scanner;

public class DeleteGivenNode {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of items: ");
		int num = in.nextInt();
		System.out.println("Enter data");
		int first = in.nextInt();
		
		myNode myLink = new myNode(first);
		for(int i =0; i < num -1; ++i){
			myLink.append(in.nextInt());
		}
		
		DeleteGivenNode obj = new DeleteGivenNode();
		boolean isDeleted = obj.deleteGivenNode(myLink);
		System.out.println("Success?: " + isDeleted);
		
	}
	
	boolean deleteGivenNode(myNode node){
		if(node == null || node.next == null){
			return false;
		}else{
			myNode next = node.next;
			node.data = next.data;
			node.next = next.next;
			return true;
		}
	}
}

class myNode{
	myNode next = null;
	int data;
	
	public myNode(int data){
		this.data = data;
	}
	
	public myNode(){
		
	}
	
	void append(int data){
		myNode end = new myNode(data);
		myNode n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}
	
	myNode deleteNode(myNode head, int data){
		myNode n = head;
		
		if(n.data == data){
			return head.next;
		}
		while(n.next != null){
			if(n.next.data == data){
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
}