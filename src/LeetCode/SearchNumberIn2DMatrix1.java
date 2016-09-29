/**
 * 	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	For example,

	Consider the following matrix:
	
	[
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
	Given target = 3, return true.
 */


package LeetCode;

import java.util.Scanner;

public class SearchNumberIn2DMatrix1 {

	public static void main(String[] args){
		int[][] matrix;
		Scanner in = new Scanner(System.in);
		matrix = new int[in.nextInt()][in.nextInt()];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				matrix[i][j] = in.nextInt();
			}
		}
		SearchNumberIn2DMatrix1 obj = new SearchNumberIn2DMatrix1();
		System.out.println("Is element available:(true/flase):: " + obj.searchMatrix(matrix, 15));
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum1 = 0;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][matrix[0].length-1] >= target){
                rowNum1 = i;
                break;
            }
        }
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[rowNum1][i] == target){
                return true;
            }
        }
        return false;
    }
}
