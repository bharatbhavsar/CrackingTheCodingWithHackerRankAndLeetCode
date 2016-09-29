/**
 * John Watson performs an operation called a right circular rotation on an array of integers, .
 *  After performing one right circular rotation operation, the array is transformed from  to .

Watson performs this operation k times. To test Sherlock's ability to identify the current 
element at a particular position in the rotated array, Watson asks q queries, where each query 
consists of a single integer, m, for which you must print the element at index m in the rotated 
array (i.e., the value of a[m]).

Input Format

The first line contains  3 space-separated integers, n, k,  and q, respectively. 
The second line contains  n space-separated integers, where each integer i describes 
array element a[i] (where 0 <= i < n ). 
Each of the  subsequent lines contains a single integer denoting .

Constraints

Output Format

For each query, print the value of the element at index  of the rotated array on a new line.

Sample Input

	3 2 3
	1 2 3
	0
	1
	2
	
	Sample Output
	
	2
	3
	1
 */




package hackerRank;

import java.util.Scanner;

public class CircularArrayRotation {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. 
         * Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int arrayLen = in.nextInt();
        int numOfRot = in.nextInt();
        int outPutLen = in.nextInt();
        
        int rotation = numOfRot%arrayLen;
        
        int[] myArray = new int[arrayLen];
        
        for(int i = 0; i < arrayLen; i++){
            myArray[i] = in.nextInt();
        }
        for(int i = 0; i < outPutLen; i++){
            int temp = in.nextInt();
            if(temp-rotation >= 0){
                System.out.println(myArray[temp-rotation]);
            }else{
                System.out.println(myArray[temp-rotation+arrayLen]);
            }
        }
    }
}
