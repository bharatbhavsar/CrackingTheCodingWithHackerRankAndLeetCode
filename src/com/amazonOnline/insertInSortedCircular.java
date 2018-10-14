package com.amazonOnline;


public class insertInSortedCircular {
	public class CNode{
		int value;
		CNode next;
		
		CNode(){
			value = 0;
			next = null;
		}
		CNode(int value){
			this.value = value;
		}
	}
	
	public class CircularList{
		CNode start;
		public CircularList(){
			start = null;
		}
		public void insert(int value){
			if(start == null){
				start = new CNode(value);
				start.next = start;
			}else{
				CNode newNode = new CNode(value);
				CNode ptr = start;
				while(ptr.next!=start){
					ptr = ptr.next;
				}
				ptr.next = newNode;
				newNode.next = start;
			}
		}
		public CNode insertInSortedOrder(int n, CNode start){
			CNode pointer = start;
			CNode newNodePointer = new CNode(n);
			if(start!=null)
			{
				if(pointer.value < n)
				{
					while(pointer.next!=start && ((pointer.next.value < n)&&(pointer.next.value > pointer.value)))
						pointer = pointer.next;
					CNode tempPointer = pointer.next;
					pointer.next = newNodePointer;
					newNodePointer.next = tempPointer;
				}else{
					do{
						//System.out.print(ptr.value + " ");
						pointer = pointer.next;
					}while(pointer.next!= start);
					pointer.next = newNodePointer;
					newNodePointer.next = start;
				}
			}else {
				newNodePointer.next = newNodePointer;
			}
			return newNodePointer;
		}
		public void display(CNode nodePtr){
			CNode ptr = nodePtr;
			do{
				System.out.print(ptr.value + " ");
				ptr = ptr.next;
			}while(ptr!=nodePtr);
		}
	}
	
	public static void main(String[] args){
		System.out.println("Circular linked list addition inn sorted order");
		insertInSortedCircular in = new insertInSortedCircular();
		CircularList cl = in.new CircularList();
		/*cl.insert(1);
		cl.insert(2);
		cl.insert(3);
		cl.insert(4);
		cl.display();*/
		CNode nodePointer = cl.insertInSortedOrder(3, null);
		CNode nodePointer1 = cl.insertInSortedOrder(1, nodePointer);

		CNode nodePointer2 = cl.insertInSortedOrder(4, nodePointer);

		CNode nodePointer3 = cl.insertInSortedOrder(2, nodePointer1);

		CNode nodePointer4 = cl.insertInSortedOrder(6, nodePointer);

		CNode nodePointer5 = cl.insertInSortedOrder(5, nodePointer);
		CNode nodePointer6 = cl.insertInSortedOrder(0, nodePointer1);
		cl.display(nodePointer6);
	}
}
