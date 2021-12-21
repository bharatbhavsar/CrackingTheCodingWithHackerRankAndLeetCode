/**
 * HackerRank Problem Statement:
 * https://www.hackerrank.com/challenges/new-year-chaos
 */

package com.hackerRank;

import java.util.Scanner;

public class NewYearChaos {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int q[] = new int[n];
            for(int q_i=0; q_i < n; q_i++){
                q[q_i] = in.nextInt();
            }
            // your code goes here
            boolean tooCheotic = false;
            int bribe=0;
            
            for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) {
                tooCheotic = true;
                break;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) bribe++;
            }
            
            
            if(tooCheotic){
                System.out.println("Too chaotic");
            }else{
                System.out.println(bribe);
            }
        }
        in.close();
    }
}
