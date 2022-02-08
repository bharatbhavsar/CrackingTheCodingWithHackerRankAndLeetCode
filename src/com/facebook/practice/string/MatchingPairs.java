package com.facebook.practice.string;

import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


public class MatchingPairs {

  // Add any helper functions you may need here

  int matchingPairs(String s, String t) {
    // Write your code here
    Set<String> misMatch = new HashSet<String>();
    char[] sChar = s.toCharArray();
    char[] tChar = t.toCharArray();
    int matching = 0;
    for(int i=0; i<sChar.length; i++){
      if(sChar[i] != tChar[i]){
        misMatch.add(sChar[i] + "" + tChar[i]);
      }else{
        matching++;
      }
    }
    for(String m:misMatch){
      String reverse = m.charAt(1) + "" + m.charAt(0);
      if(misMatch.contains(reverse)){
        return matching + 2;
      }
    }
    if(misMatch.size()<=1)
      matching--;
    if(misMatch.size()==0)
      matching--;
    
    return matching;
  }


  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  public void run() {
    String s_1 = "abcde";
    String t_1 = "adcbe";
    int expected_1 = 5;
    int output_1 = matchingPairs(s_1, t_1);
    check(expected_1, output_1);

    String s_2 = "abcd";
    String t_2 = "abcd";
    int expected_2 = 2;
    int output_2 = matchingPairs(s_2, t_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  public static void main(String[] args) {
    new MatchingPairs().run();
  }
}