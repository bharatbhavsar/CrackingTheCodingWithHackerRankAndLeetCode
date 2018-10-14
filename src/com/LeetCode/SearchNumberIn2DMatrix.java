/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
	
	Integers in each row are sorted in ascending from left to right.
	Integers in each column are sorted in ascending from top to bottom.
	For example,
	
	Consider the following matrix:
	
	[
	  [1,   4,  7, 11, 15],
	  [2,   5,  8, 12, 19],
	  [3,   6,  9, 16, 22],
	  [10, 13, 14, 17, 24],
	  [18, 21, 23, 26, 30]
	]
	Given target = 5, return true.
	
	Given target = 20, return false.
 */


package com.LeetCode;

import java.util.Scanner;

public class SearchNumberIn2DMatrix {

	public static void main(String[] args){
		int[][] matrix;
		Scanner in = new Scanner(System.in);
		matrix = new int[in.nextInt()][in.nextInt()];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				matrix[i][j] = in.nextInt();
			}
		}
		SearchNumberIn2DMatrix obj = new SearchNumberIn2DMatrix();
		System.out.println("Is element available:(true/flase):: " + obj.searchMatrix(matrix, 15));
		in.close();
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        int rowNumber = matrix.length - 1, colNumber = matrix[0].length - 1;
        int i = rowNumber, j = 0;
        
        while(i >= 0 && j <= colNumber){
            if(target < matrix[i][j]){
                i--;
            }else if(target > matrix[i][j]){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}
