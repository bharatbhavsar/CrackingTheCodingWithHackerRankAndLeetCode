/**
 * HackerRank problem statement Link:
 * https://www.hackerrank.com/challenges/palindrome-index
 */

package com.hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteIndexToMakePalindrome {

	public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            final char[] C = br.readLine().toCharArray();
            final int N = C.length;
            int c = -1;
            for(int i = 0, j = N-1; i < j; ++i, --j){
                if (C[i] != C[j]){
                    c = isPalindrome(C, i+1, j+1) ? i : j;
                    break;
                }
            }
            sb.append(c + "\n");
        }
        System.out.print(sb);
    }
    
    private static boolean isPalindrome(final char[] C, final int A, final int B){
        for(int i = A, j = B-1; i < j; ++i, --j){
            if (C[i] != C[j]){
                return false;
            }
        }
        return true;
    }
}
