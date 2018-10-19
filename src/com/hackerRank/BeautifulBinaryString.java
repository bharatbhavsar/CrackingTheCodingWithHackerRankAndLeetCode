/**
 * Problem Statement at HackerRank:
 * https://www.hackerrank.com/challenges/beautiful-binary-string
 */

package com.hackerRank;

import java.util.Scanner;

public class BeautifulBinaryString {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String B = in.next();
        int steps=0;
        for(int i=0;i<B.length()-2;){
            if(B.substring(i,i+3).equals("010")){
                steps++;
                i=i+3;
            }else{
                i++;
            }
        }
        System.out.println(steps);
        in.close();
    }
}
