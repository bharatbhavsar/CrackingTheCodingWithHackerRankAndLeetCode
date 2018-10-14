/**
 * Problem Description at HackerRank site:
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds
 */

package com.hackerRank;

import java.util.Scanner;

public class JumpingOnCloudsGame {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int jumps=-1;
        for (int i = 0; i < n; i++, jumps++) {
            if (i<n-2 && c[i+2]==0) i++;
        }
        System.out.println(jumps);
        
    }
}
