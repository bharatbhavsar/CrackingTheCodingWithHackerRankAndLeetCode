package com.facebook.practice.string;

/*
 * 
You are given two strings s and t. You can select any substring of string s and rearrange the characters of the selected substring. Determine the minimum length of the substring of s such that string t is a substring of the selected substring.
Signature
int minLengthSubstring(String s, String t)
Input
s and t are non-empty strings that contain less than 1,000,000 characters each
Output
Return the minimum length of the substring of s. If it is not possible, return -1
Example
s = "dcbefebce"
t = "fd"
output = 5
Explanation:
Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. String t is a substring of "cfdeb". Thus, the minimum length required is 5.
 * 
 */

import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


public class MinimumLengthSubstrings {

  // Add any helper functions you may need here
  

  int minLengthSubstring(String s, String t) {
    // Write your code here
    int lastIndex = 0;
    for(int i = 0; i < s.length(); i++){
      if(isSubstring(s.substring(0, i+1), t)){
        lastIndex = i;
        break;
      }
      lastIndex = i+1;
    }
    if(lastIndex == s.length()){
      if(isSubstring(s,t)){
        lastIndex--;
      }else{
        return -1;
      }
    }
    int firstIndex = 0;
    for(int i = 0; i <= lastIndex; i++){
      if(!isSubstring(s.substring(i, lastIndex+1), t)){
        firstIndex = i - 1;
        break;
      }
      firstIndex = i;
    }
    return lastIndex - firstIndex + 1;
  }
  
  boolean isSubstring(String s, String t){
    if(s.length() < t.length()){
      return false;
    }
    ArrayList<Character> tList = new ArrayList<Character>();
    
    for(int i = 0; i < t.length(); i++){
      tList.add((Character)t.charAt(i));
    }
    
    for(int i = 0; i < s.length(); i++){
      if(tList.contains((Character)s.charAt(i))){
        tList.remove((Character)s.charAt(i));
      }
    }
    
    return tList.size() == 0;
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
  public void run() throws IOException {
    String s_1 = "dcbefebce";
    String t_1 = "fd";
    int expected_1 = 5;
    int output_1 = minLengthSubstring(s_1, t_1);
    check(expected_1, output_1);

    String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
    String t_2 = "cbccfafebccdccebdd";
    int expected_2 = -1;
    int output_2 = minLengthSubstring(s_2, t_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  public static void main(String[] args) throws IOException {
    new MinimumLengthSubstrings().run();
  }
}
