package com.goDaddyHackerRankTest;

public class DeleteNode {

	public static void main(String[] args){
		LinkedListNode temp = new LinkedListNode();
		LinkedListNode head = temp;
		int[] ar = {5,2,1,6,7};
		temp.val = 5;
		for(int i=2; i<=5; i++){
			LinkedListNode t1 = new LinkedListNode();
			t1.val=ar[i-1];
			temp.next=t1;
			temp=t1;
		}
		
		head = removeNodes(head, 5);
		temp=head;
		while(temp!=null){
			System.out.println(temp.val);
			temp=temp.next;
		}
		
	}
	    static LinkedListNode removeNodes(LinkedListNode list, int x) {

	    	if(list==null){
	    		return null;
	    	}
	    	
	    	LinkedListNode head = list;
	    	while(head.val>x && head.next!=null){
	    		head=head.next;
	    	}
	    	if(head.val>x){
	    		head=head.next;
	    	}
	    	
	    	LinkedListNode prev = list;
	    	LinkedListNode next = prev;
	    	if(prev!=null){
	    		next = next.next;
	    	}
	    	while(next!=null){
	    		while(next!=null && next.val>x){
	    			prev.next=next.next;
	    			next=next.next;
	    		}
	    		prev=prev.next;
	    		if(next!=null)
	    			next=next.next;
	    	}
	    	return head;
	    }
}

class LinkedListNode {
    int val;
    LinkedListNode next;
    
}
