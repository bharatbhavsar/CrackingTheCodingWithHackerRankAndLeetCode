/**
 * Roy wanted to increase his typing speed for programming contests. 
 * So, his friend advised him to type the sentence "The quick brown fox jumps over 
 * the lazy dog" repeatedly, because it is a pangram. (Pangrams are sentences constructed 
 * by using every letter of the alphabet at least once.)
 * 
 * After typing the sentence several times, Roy became bored with it. 
 * So he started to look for other pangrams.
 * 
 * Given a sentence S, tell Roy if it is a pangram or not.
 * 
 * HackerRank Link:
 * https://www.hackerrank.com/challenges/pangrams
 */

package com.hackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class PangramCheck {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        HashSet<Character> chars = new HashSet<Character>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        line = line.toLowerCase();
        for(int i=0; i<line.length(); i++){
            if(line.charAt(i)!=' ' && !chars.contains(line.charAt(i))){
                chars.add(line.charAt(i));
            }
        }
        if(chars.size()==26){
            System.out.println("pangram");
        }else{
            System.out.println("not pangram");
        }
    }
}
