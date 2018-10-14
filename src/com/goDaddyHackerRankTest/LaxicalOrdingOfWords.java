/**
 * Given a word w, rearrange the letters of w to construct another word s in such a way that,
 * s is lexicographically greater than w. In case of multiple possible answers, 
 * find the lexicographically smallest one.

	Input Format The first line of input contains t, number of test cases.
	Each of the next t lines contains w.

	Constraints 1<= t <= 105 1<=|w|<=100 w will contain only lower case english letters 
	and its' length will not exceed 100.

	Output Format For each testcase, output a string lexicographically bigger than w 
	in a separate line. In case of multiple possible answers, print the lexicographically 
	smallest one and if no answer exists, print no answer.
	
 * 
 * HackerRank Description Link:
 * https://www.hackerrank.com/challenges/bigger-is-greater
 */
package com.goDaddyHackerRankTest;

import java.util.Scanner;

public class LaxicalOrdingOfWords {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfWords = in.nextInt();
        in.nextLine();
        String[] words = new String[numberOfWords];
        for(int i = 0; i<numberOfWords; i++){
            words[i] = in.nextLine();
        }
        
        for(int i = 0; i<numberOfWords; i++){
            
            char[] letters = words[i].toCharArray();
            int k=-1,l=-1;
            for(int m=letters.length-2;m>=0;m--){
                if(letters[m]<letters[m+1]){
                    k=m;
                    break;
                }
            }
            if(k==-1){
                System.out.println("no answer");
            }else{
                for(int m=letters.length-1;m>k;m--){
                    if(letters[m]>letters[k]){
                        l=m;
                        break;
                    }
                }
                char temp = letters[k];
                letters[k] = letters[l];
                letters[l] = temp;
                char[] newWord = new char[letters.length];
                for(int m=0;m<k+1;m++){
                    newWord[m]=letters[m];
                }
                int j=1;
                for(int m=letters.length-1;m>k;m--){
                    newWord[k+j]=letters[m];
                    j++;
                }
                System.out.println(new String(newWord));
            }
        }
    }
}
