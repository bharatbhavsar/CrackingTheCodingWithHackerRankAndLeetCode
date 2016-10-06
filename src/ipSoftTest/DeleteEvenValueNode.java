package ipSoftTest;

public class DeleteEvenValueNode {

	static LinkedListNode deleteEven(LinkedListNode list) {
        //check if list is null
        if(list == null){
            return null;
        }
        
        //go till first odd node
        LinkedListNode head = list;
        while(head.val%2==0 && head.next!=null){
            head = head.next;
        }
        if(head.val%2==0){
            head=head.next;
        }

        //reference nodes for prev and next nodes
        LinkedListNode t1 = list;
        LinkedListNode t2 = t1;
        if(t1!=null){
            t2 = t2.next;
        }
        
        while(t2 != null){
            while(t2 != null && t2.val%2==0){
                t1.next = t2.next;
                t2 = t2.next;
            }
            t1 = t1.next;
            if(t2!= null)
                t2 = t2.next;
        }
        return head;

    }
}

class LinkedListNode {
    int val;
    LinkedListNode next;
};
