package linkedList;
import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicateLinkedList {

	
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
		RemoveDuplicateLinkedList obj = new RemoveDuplicateLinkedList();
		obj.deleteDuplicate(myLink);
		System.out.println("Entered linked list: ");
		myNode forPrinting = myLink;
		while(forPrinting != null){
			System.out.print(forPrinting.data + " ");
			forPrinting = forPrinting.next;
		}
	}
	
	void deleteDuplicate(myNode myLink){
		HashSet<Integer> mySet = new HashSet<Integer>();
		myNode previous = null;
		
		while(myLink != null){
			if(mySet.contains(myLink.data)){
				previous.next = myLink.next;
			}else{
				mySet.add(myLink.data);
				previous = myLink;
			}
			myLink = myLink.next;
		}
	}
}

