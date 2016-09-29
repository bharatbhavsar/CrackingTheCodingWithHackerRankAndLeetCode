/**
 * Given a linked list, swap every two adjacent nodes and return its head.

	For example, given 1->2->3->4, you should return the list as 2->1->4->3.

	Your algorithm should use only constant space. You may not modify the values in the list, 
	only nodes itself can be changed.
	
 */

package LeetCode;

public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode next = head;
        ListNode prev = head.next;
        ListNode result = head.next;
        
        ListNode last = new ListNode(0);
        
        while(next !=null && next.next!=null){
            next.next = prev.next;
            prev.next = next;
            last.next = prev;
            last = next;
            next = next.next;
            if(next!=null){
                prev = next.next;
            }
        }
        return result;
    }
}
