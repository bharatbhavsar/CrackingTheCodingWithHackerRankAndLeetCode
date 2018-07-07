package linkedList;

import java.util.Scanner;

public class Partition {

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
		System.out.println("Enter pivot number: ");
		int pivot = in.nextInt();
		Partition obj = new Partition();
		myLink = obj.myPartition(myLink, pivot);
		myNode temp = myLink;
		while(temp.next!=null){
			System.out.print(temp.data + " ->");
			temp = temp.next;
		}
		System.out.print(temp.data );
		in.close();
	}
	
	myNode myPartition(myNode node, int pivot){
		myNode beforeStart = null;
		myNode beforeEnd = null;
		myNode afterStart = null;
		myNode afterEnd = null;
		
		while(node != null){
			myNode next = node.next;
			node.next = null;
			
			if(node.data < pivot){
				if(beforeStart == null){
					beforeStart = node;
					beforeEnd = beforeStart;
				}else{
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}else{
				if(afterStart==null){
					afterStart = node;
					afterEnd = afterStart;
				}else{
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		
		if(beforeStart == null){
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}
}

