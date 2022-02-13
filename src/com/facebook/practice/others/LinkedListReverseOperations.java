package com.facebook.practice.others;

/*
 *

You are given a singly-linked list that contains N integers. A subpart of the list is a contiguous set of even elements, bordered either by either end of the list or an odd element. For example, if the list is [1, 2, 8, 9, 12, 16], the subparts of the list are [2, 8] and [12, 16].
Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list, [1, 8, 2, 9, 16, 12].
The goal of this question is: given a resulting list, determine the original order of the elements.
Implementation detail:
You must use the following definition for elements in the linked list:
class Node {
    int data;
    Node next;
}
Signature
Node reverse(Node head)
Constraints
1 <= N <= 1000, where N is the size of the list
1 <= Li <= 10^9, where Li is the ith element of the list
Example
Input:
N = 6
list = [1, 2, 8, 9, 12, 16]
Output:
[1, 8, 2, 9, 16, 12]

 * 
 */

import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


public class LinkedListReverseOperations {

  
  class Node {
    int data;
    Node next;
    Node(int x) {
      data = x;
      next = null;
    }
  }
  
  
  Node reverseEven(Node head) {
	  Node prev = null;
	  Node curr = head;
	  
	  while(curr != null && curr.data % 2 == 0) {
		  Node temp = curr.next;
		  curr.next = prev;
		  prev = curr;
		  curr = temp;
	  }
	  
	  head.next = curr;
	  return prev;
  }
  
  Node reverse(Node head) {
	  Node dummy = new Node(0);
	  dummy.next = head;
	  
	  
	  Node prev = dummy;
	  Node curr = head;
	  
	  while(curr != null) {
		  if(curr.data % 2 == 0) {
			  prev.next = reverseEven(curr);
		  }
		  prev = curr;
		  curr = curr.next;
	  }
	  
	  return dummy.next;
  }
  
  
  
 //These are the tests we use to determine if the solution is correct.
 // You can add your own at the bottom.
 int test_case_number = 1;

 void printLinkedList(Node head) {
   System.out.print("[");
   while (head != null) {
     System.out.print(head.data);
     head = head.next;
     if (head != null)
       System.out.print(" ");
   }
   System.out.print("]");
 }
 void check(Node expectedHead, Node outputHead) {
   boolean result = true;
   Node tempExpectedHead = expectedHead;
   Node tempOutputHead = outputHead;
   while (expectedHead != null && outputHead != null) {
     result &= (expectedHead.data == outputHead.data);
     expectedHead = expectedHead.next;
     outputHead = outputHead.next;
   }
   if (!(expectedHead == null && outputHead == null)) result = false;

   char rightTick = '\u2713';
   char wrongTick = '\u2717';
   if (result) {
     System.out.println(rightTick + " Test #" + test_case_number);
   } else {
     System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
     printLinkedList(tempExpectedHead); 
     System.out.print(" Your output: ");
     printLinkedList(tempOutputHead);
     System.out.println();
   }
   test_case_number++;
 }
 Node createLinkedList(int[] arr) {
   Node head = null;
   Node tempHead = head;
   for (int v : arr) {
     if (head == null) {
       head = new Node(v);
       tempHead = head;
     } else {
       head.next = new Node(v);
       head = head.next;
     }
   }
   return tempHead;
 }
 
 public void run() {
 
   int[] arr_1 = {1, 2, 8, 9, 12, 16};
   int[] expected1 = {1, 8, 2, 9, 16, 12};
   Node head_1 = createLinkedList(arr_1);
   Node expected_1 = createLinkedList(expected1);
   Node output_1 = reverse(head_1);
   check(expected_1, output_1);

   int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
   int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
   Node head_2 = createLinkedList(arr_2);
   Node expected_2 = createLinkedList(expected2);
   Node output_2 = reverse(head_2);
   check(expected_2, output_2);
 
   // Add your own test cases here
   
 }
 
 public static void main(String[] args) {
   new LinkedListReverseOperations().run();
 }
}