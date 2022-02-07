package com.facebook.practice;

import java.io.*; 
import java.util.*;

public class PassingYearBook {
	// Add any helper functions you may need here
	  

	  int[] findSignatureCounts(int[] arr) {
	    // Write your code here
	    ArrayList<Integer> std = new ArrayList<Integer>(arr.length);
	    for(int i=0; i < arr.length; i++){
	      std.add(new Integer(arr[i]));
	    }
	    ArrayList<Integer> book = new ArrayList<Integer>(std);
	    ArrayList<Integer> res = new ArrayList<Integer>(Collections.nCopies(arr.length, 0));
	    int numberOfSigns = 0;
	    Set<Integer> out_of_loop = new HashSet<Integer>();
	    while(book.size() != out_of_loop.size()){
	        book = giveItToSign(std, book);
	        numberOfSigns = numberOfSigns + 1;
	        ArrayList<Integer> toRemove = new ArrayList<Integer>();
	        for(int i = 0; i < book.size(); i++){
	            if((int)std.get(i) == (int)book.get(i)){
	                toRemove.add(std.get(i));
	            }
	        }
	        for(Integer i:toRemove){
	            res.set(i - 1, new Integer(numberOfSigns));
	            int j = std.indexOf(i);
	            book.set(j, 0);
	            out_of_loop.add(i);
	        }
	    }
	    if(book.size() == 1){
	      res.add(book.get(0), numberOfSigns);
	    }
	    return res.stream().mapToInt(Integer::intValue).toArray();
	  }

	  ArrayList<Integer> giveItToSign(ArrayList<Integer> std, ArrayList<Integer> book){
	    ArrayList<Integer> newBook = new ArrayList<Integer>(Collections.nCopies(book.size(), 0));
	    for(int i = 0; i < book.size(); i++){
	      int pos = std.get(i);
	      int val = book.get(i);
	      newBook.set(pos - 1, val);
	    }
	    return newBook;
	  }










	  // These are the tests we use to determine if the solution is correct.
	  // You can add your own at the bottom.
	  int test_case_number = 1;
	  void check(int[] expected, int[] output) {
	    int expected_size = expected.length; 
	    int output_size = output.length; 
	    boolean result = true; 
	    if (expected_size != output_size) {
	      result = false;
	    }
	    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
	      result &= (output[i] == expected[i]);
	    }
	    char rightTick = '\u2713';
	    char wrongTick = '\u2717';
	    if (result) {
	      System.out.println(rightTick + " Test #" + test_case_number);  
	    }
	    else {
	      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
	      printIntegerArray(expected); 
	      System.out.print(" Your output: ");
	      printIntegerArray(output);
	      System.out.println();
	    }
	    test_case_number++;
	  }
	  void printIntegerArray(int[] arr) {
	    int len = arr.length; 
	    System.out.print("[");
	    for(int i = 0; i < len; i++) {
	      if (i != 0) {
	        System.out.print(", ");
	      }
	      System.out.print(arr[i]);
	    }
	    System.out.print("]");
	  }
	  
	  public void run() {
	    int[] arr_1 = {4, 1, 2, 3};
	    int[] expected_1 = {4,4,4,4};
	    int[] output_1 = findSignatureCounts(arr_1);
	    check(expected_1, output_1);
	    
	    int[] arr_2 = {1, 2};
	    int[] expected_2 = {1, 1};
	    int[] output_2 = findSignatureCounts(arr_2);
	    check(expected_2, output_2);
	  
	    // Add your own test cases here
	    
	  }
	  
	  public static void main(String[] args) throws IOException {
	    new PassingYearBook().run();
	  }
}
