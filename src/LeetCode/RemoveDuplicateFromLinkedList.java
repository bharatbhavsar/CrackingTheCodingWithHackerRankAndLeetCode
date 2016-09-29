package LeetCode;

public class RemoveDuplicateFromLinkedList {

	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
 
        ListNode iterator = head;
 
        while( iterator!= null && iterator.next != null){
            if(iterator.val == iterator.next.val){
                iterator.next = iterator.next.next;
            }else{
                iterator = iterator.next; 
            }
        }
 
        return head;
    }
}
