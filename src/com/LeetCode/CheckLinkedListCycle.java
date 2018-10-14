/**
 * Given a linked list, determine if it has a cycle in it.
 */

package com.LeetCode;

public class CheckLinkedListCycle {

	/**
	 * With do-while loop
	 * @param head
	 * @return
	 */
	public boolean hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        do{
            if(fast==null || fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
            
        }while(slow!=fast);
        return true;
    }
	
	/**
	 * With while loop
	 * @param head
	 * @return
	 */
	public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
 
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
 
            if(slow == fast)
                return true;
        }
 
        return false;
    }
}
