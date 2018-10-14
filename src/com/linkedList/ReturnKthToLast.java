package com.linkedList;

import java.util.Scanner;

public class ReturnKthToLast {

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
		
		ReturnKthToLast obj = new ReturnKthToLast();
		myNode kthNodeFromLast = obj.kthToLast(myLink, 5);
		System.out.println(kthNodeFromLast);
		in.close();
	}
	
	myNode kthToLast(myNode node, int k){
		myNode p1 = node;
		myNode p2 = node;
		
		for(int i = 0; i < k; i++){
			if(p1 == null){
				return null;
			}else{
				p1 = p1.next;
			}
		}
		
		while(p1 != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
	}
}

