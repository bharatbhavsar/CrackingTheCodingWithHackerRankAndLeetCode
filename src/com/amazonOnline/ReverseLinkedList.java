package com.amazonOnline;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// LNode CLASS IS DEFINED BY DEFAULT
// CLASS BEGINS, THIS CLASS IS REQUIRED

class LNode{
	LNode next;
}

public class ReverseLinkedList
{
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public static LNode reverseLinkedList(LNode list)
  {
    // INSERT YOUR CODE HERE
    if(list == null || list.next == null)
        return list;
    LNode centerNode = getCenter(list);
    centerNode.next = reverse(centerNode.next);
    return list;
	
  }
  // METHOD SIGNATURE ENDS
   	public static LNode getCenter(LNode head) {
		LNode previousSlowPointer = null;
		LNode slowPointer = head;
		LNode fastPointer = head;
		
		if (head != null) {
			while (fastPointer != null && fastPointer.next != null) {
				previousSlowPointer = slowPointer;
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next.next;
			}
		}
		return previousSlowPointer;
	}

	public static LNode reverse(LNode head) {
		if (head != null) {
			LNode previous;
			LNode nextNode;
			LNode current;
			previous = null;
			current = null;
			nextNode = head;
			while (nextNode != null) {
				current = nextNode;
				nextNode = current.next;
				current.next = previous;
				previous = current;

			}
			previous = null;
			nextNode = null;
			return current;
		}
		return null;
	}
}