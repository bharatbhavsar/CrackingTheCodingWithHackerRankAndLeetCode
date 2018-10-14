/**
 * HackerRank Problem Link:
 * https://www.hackerrank.com/challenges/the-love-letter-mystery
 */

package com.hackerRank;

import java.util.Scanner;

public class LoveLetterMystery {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        in.nextLine();
        for(int k=0; k<testCases; k++){
            String current = in.nextLine();
            int i=0;
            int j = current.length()-1;
            int change=0;
            while(i<j){
                change += Math.abs((int)current.charAt(i)-(int)current.charAt(j));
                i++;
                j--;
            }
            System.out.println(change);
        }
    }
}
