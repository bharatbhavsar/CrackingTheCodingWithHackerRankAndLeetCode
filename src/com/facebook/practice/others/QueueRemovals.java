package com.facebook.practice.others;

/*
 * 
You're given a list of n integers arr, which represent elements in a queue (in order from front to back). You're also given an integer x, and must perform x iterations of the following 3-step process:
Pop x elements from the front of queue (or, if it contains fewer than x elements, pop all of them)
Of the elements that were popped, find the one with the largest value (if there are multiple such elements, take the one which had been popped the earliest), and remove it
For each one of the remaining elements that were popped (in the order they had been popped), decrement its value by 1 if it's positive (otherwise, if its value is 0, then it's left unchanged), and then add it back to the queue
Compute a list of x integers output, the ith of which is the 1-based index in the original array of the element which had been removed in step 2 during the ith iteration.
Signature
int[] findPositions(int[] arr, int x)
Input
x is in the range [1, 316].
n is in the range [x, x*x].
Each value arr[i] is in the range [1, x].
Output
Return a list of x integers output, as described above.
Example
n = 6
arr = [1, 2, 2, 3, 4, 5]
x = 5
output = [5, 6, 4, 1, 2]
The initial queue is [1, 2, 2, 3, 4, 5] (from front to back).
In the first iteration, the first 5 elements are popped off the queue, leaving just [5]. Of the popped elements, the largest one is the 4, which was at index 5 in the original array. The remaining elements are then decremented and added back onto the queue, whose contents are then [5, 0, 1, 1, 2].
In the second iteration, all 5 elements are popped off the queue. The largest one is the 5, which was at index 6 in the original array. The remaining elements are then decremented (aside from the 0) and added back onto the queue, whose contents are then [0, 0, 0, 1].
In the third iteration, all 4 elements are popped off the queue. The largest one is the 1, which had the initial value of 3 at index 4 in the original array. The remaining elements are added back onto the queue, whose contents are then [0, 0, 0].
In the fourth iteration, all 3 elements are popped off the queue. Since they all have an equal value, we remove the one that was popped first, which had the initial value of 1 at index 1 in the original array. The remaining elements are added back onto the queue, whose contents are then [0, 0].
In the final iteration, both elements are popped off the queue. We remove the one that was popped first, which had the initial value of 2 at index 2 in the original array.
 * 
 */

import java.util.*;
// Add any extra import statements you may need here


public class QueueRemovals {

  // Add any helper functions you may need here
  
  class MyList{
    ArrayList<Integer> pos = new ArrayList<Integer>();
    ArrayList<Integer> value = new ArrayList<Integer>();
    ArrayList<Integer> res = new ArrayList<Integer>();
    
    MyList(int[] arr){
      for(int i = 0; i < arr.length; i++){
        pos.add(i+1);
        value.add(arr[i]);
      }
    }
  }
  
  MyList doOperations(MyList listObj, int x){
    ArrayList<Integer> tempPos = new ArrayList<Integer>();
    ArrayList<Integer> tempVal = new ArrayList<Integer>();
    while(x > 0 && listObj.pos.size() > 0){
      tempPos.add(listObj.pos.get(0));
      tempVal.add(listObj.value.get(0));
      listObj.pos.remove(0);
      listObj.value.remove(0);
      x--;
    }
    Integer rm = -1;
    int pos = -1;
    for(int i = 0; i < tempVal.size(); i++){
      if(rm < tempVal.get(i)){
        rm = tempVal.get(i);
        pos = i;
      }
    }
    listObj.res.add(tempPos.get(pos));
    tempPos.remove(pos);
    tempVal.remove(rm);
    for(int i = 0; i < tempVal.size(); i++){
      if(tempVal.get(i) > 0){
        tempVal.set(i, tempVal.get(i)-1);
      }
    }
    listObj.pos.addAll(tempPos);
    listObj.value.addAll(tempVal);
    return listObj;
  }
    
    
     

  int[] findPositions(int[] arr, int x) {
    // Write your code here
    MyList listObj = new MyList(arr);
    int interations = x;
    while(interations > 0){
      listObj = doOperations(listObj, x);
      interations--;
    }
    return listObj.res.stream().mapToInt(Integer::intValue).toArray();
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
    int x_1 = 5;
    int[] arr_1 = {1, 2, 2, 3, 4, 5};
    int[] expected_1 = {5, 6, 4, 1, 2 };
    int[] output_1 = findPositions(arr_1, x_1);
    check(expected_1, output_1);
    
    int x_2 = 4;
    int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
    int[] expected_2 = {2, 5, 10, 13};
    int[] output_2 = findPositions(arr_2, x_2);
    check(expected_2, output_2);
  
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new QueueRemovals().run();
  }
}
