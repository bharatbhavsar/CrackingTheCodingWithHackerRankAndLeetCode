/**
 * Problem Statement:

	A jail has N prisoners, and each prisoner has a unique id number, S, 
	ranging from 1 to N. There are M sweets that must be distributed to the prisoners.
	
	The jailer decides the fairest way to do this is by sitting the prisoners down in a circle 
	(ordered by ascending S), and then, starting with some random S, distribute one candy at a 
	time to each sequentially numbered prisoner until all M candies are distributed. 
	For example, if the jailer picks prisoner S = 2, then his distribution order would be 
	(2, 3, 4, 5,..., n-1, n, 1, 2, 3, 4,...) until all M sweets are distributed.
	
	But wait—there's a catch—the very last sweet is poisoned! Can you find and print the ID number 
	of the last prisoner to receive a sweet so he can be warned?
	
	Input Format:
	
	The first line contains an integer, T, denoting the number of test cases. 
	The T subsequent lines each contain 3 space-separated integers: 
	N (the number of prisoners), M (the number of sweets), and S (the prisoner ID), 
	respectively.
	
	Output Format:
	
	For each test case, print the ID number of the prisoner who receives the poisoned sweet on a 
	new line.
 */


package hackerRank;

import java.util.Scanner;

public class SavePrisoner {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i=0; i<testCases; i++){
            long prisoners = in.nextLong();
            long sweets = in.nextLong();
            long starter = in.nextInt();
            long result = (starter+sweets-1)%prisoners;
            if(result==0){
                System.out.println(prisoners);
            }else{
                System.out.println(result);
            }
        }
    }
}
