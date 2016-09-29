package linkedList;

public class ReverseLikedList {

	public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode current = head;
        ListNode next = current.next;
        head.next=null;
        
        while(current!=null && next !=null){
            ListNode temp = next.next;
            next.next=current;
            current=next;
            next=temp;
        }
        return current;
    }
	
	/**
	 * This is recursive solution.
	 * @param head
	 * @return
	 */
	public ListNode reverseListRecursive(ListNode head) {
	    if(head==null || head.next == null)
	        return head;
	 
	    //get second node    
	    ListNode second = head.next;
	    //set first's next to be null
	    head.next = null;
	 
	    ListNode rest = reverseList(second);
	    second.next = head;
	 
	    return rest;
	}
}

class ListNode{
	ListNode next;
	int value;
	public ListNode(int val){
		value=val;
	}
}
