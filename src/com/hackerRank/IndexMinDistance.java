/**
 * HackerRank Problem statement:
 * https://www.hackerrank.com/challenges/minimum-distances
 */

package com.hackerRank;

import java.util.HashMap;
import java.util.Scanner;

public class IndexMinDistance {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> myMap = new HashMap<Integer,Integer>();
        int min = Integer.MAX_VALUE;
        int n = in.nextInt();
        int A[] = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
            if(myMap.containsKey(A[A_i])){
                int x = myMap.get(A[A_i]);
                int diff = A_i - x;
                if(diff<min)
                    min=diff;
            }
            myMap.put(A[A_i],A_i);
        }
        if(min==Integer.MAX_VALUE)
            min=-1;
        System.out.println(min);
        in.close();
    }
}
