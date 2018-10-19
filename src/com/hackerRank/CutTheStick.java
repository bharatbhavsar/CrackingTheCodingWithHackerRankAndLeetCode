/**
 * sticks-length        length-of-cut   sticks-cut
	5 4 4 2 2 8             2               6
	3 2 2 _ _ 6             2               4
	1 _ _ _ _ 4             1               2
	_ _ _ _ _ 3             3               1
	_ _ _ _ _ _           DONE            DONE

 *
 *
 *	Sample Input 0

	6
	5 4 4 2 2 8
	Sample Output 0
	
	6
	4
	2
	1
	------------------
	
	Sample Input 1
	
	8
	1 2 3 4 3 3 2 1
	
	Sample Output 1
	
	8
	6
	4
	1

 */

package com.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class CutTheStick {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int initialNum = in.nextInt();
        int[] array = new int[initialNum];
        for(int i = 0; i < initialNum; i++){
            array[i] = in.nextInt();
        }
        Arrays.sort(array);
        int i=0;
        int sizeRemaining = initialNum;
        while(i<=initialNum-1){
            int currentDeleted=1;
            System.out.println(sizeRemaining);
            while(i<initialNum-1 && array[i]==array[i+1]){
                i++;
                currentDeleted++;
            }
            i++;
            sizeRemaining -=currentDeleted;
        }
        in.close();
    }
}
