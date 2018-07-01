package com.arrayandstring;

import java.io.*;


public class ArrayManupulation {
	// Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] zeros = new long[n+1];
        
        for(int i = 0; i < queries.length; i++){
            zeros[queries[i][0]-1] += queries[i][2];
            zeros[queries[i][1]]   -= queries[i][2];
        }     
        long sum = 0;
        long max = 0;
        System.out.println(zeros.length);
        for(long i: zeros){
            System.out.print(i+" ");
        }
        for (int i = 0; i < n; i++) {
            sum += zeros[i];
            max = Math.max(max, sum);
        }
        
        return max;
    }
    	
    public static void main(String[] args) throws IOException {
        int sizeOfArray = 5;
        int[][] queries= {{1, 2, 100},{2, 5, 100},{3, 4, 100}};
        System.out.println(arrayManipulation(sizeOfArray, queries));
    }
}
