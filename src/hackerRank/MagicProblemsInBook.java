/**
 * HackerRank Problem statement Link:
 * https://www.hackerrank.com/challenges/lisa-workbook
 */

package hackerRank;

import java.util.Scanner;

public class MagicProblemsInBook {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numOfChapters = in.nextInt();
        int numOfMaxProbPerPage = in.nextInt();
        int magicProblems=0;
        int[] chapter = new int[numOfChapters];
        int pageNumber = 1;
        for(int i=1; i<=numOfChapters; i++){
            chapter[i-1]=in.nextInt();
            int j = 1;
            while(j<=chapter[i-1]){
                
                if(j==pageNumber){
                    magicProblems++;
                }
                if(j%numOfMaxProbPerPage == 0){
                    pageNumber++;
                }
                j++;
            }
            if(j%numOfMaxProbPerPage!=1){
                pageNumber++;
            }
        }
        System.out.println(magicProblems);
    }
}
