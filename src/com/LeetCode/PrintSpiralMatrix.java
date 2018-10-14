/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 */

package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiralMatrix {

	public static void main(String[] args){
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
				};
		for(Integer i : spiralList(matrix)){
			System.out.print(i + " ");
		}
	}
	
	static List<Integer> spiralList(int[][] matrix){
		List<Integer> result = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return result;
		}
		
		int left = 0;
		int right = matrix[0].length - 1;
		int top = 0;
		int bottom = matrix.length - 1;
		
		while(result.size()< (matrix.length * matrix[0].length)){
			for(int i = left; i <= right; i++){
				result.add(matrix[top][i]);
			}
			top++;
			
			for(int i = top; i <= bottom; i++){
				result.add(matrix[i][right]);
			}
			right--;
			
			if(bottom<top){
				break;
			}
			
			for(int i = right; i >= left; i--){
				result.add(matrix[bottom][i]);
			}
			bottom--;
			
			if(right<left){
				break;
			}
			
			for(int i = bottom; i>= top; i--){
				result.add(matrix[i][left]);
			}
			left++;
		}
		return result;
	}
}
