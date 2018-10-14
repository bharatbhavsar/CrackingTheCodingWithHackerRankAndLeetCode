/**
 * Remove all elements from a linked list of integers that have value val.

	Example
	Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	Return: 1 --> 2 --> 3 --> 4 --> 5
 */

package com.LeetCode;

public class RemoveElementsLinkedList {

	public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode result=head;
        while(result!=null && result.val==val){
            result= result.next;
        }
        ListNode temp=result;
        while(temp!=null && temp.next!=null){
            while(temp.next!=null && temp.next.val==val){
                temp.next=temp.next.next;
                
            }
            temp=temp.next;
        }
        return result;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x){ 
    	 val = x;
    	 next = null;
     }
}
