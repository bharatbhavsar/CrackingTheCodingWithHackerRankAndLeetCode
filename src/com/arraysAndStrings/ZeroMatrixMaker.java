package com.arraysAndStrings;
import java.util.Scanner;

public class ZeroMatrixMaker {

	public static void main(String[] args){
		int[][] matrix, matrixZerowed;
		Scanner in = new Scanner(System.in);
		int numberOfRows = in.nextInt();
		int numberOfColumns = in.nextInt();
		matrix = new int[numberOfRows][numberOfColumns];
		for(int i =0; i<numberOfRows;i++){
			for(int j=0; j<numberOfColumns;j++){
				matrix[i][j]=in.nextInt();
				
			}
			
		}
		System.out.println("\nOriginal Matrix:\n");
		for(int i =0; i<numberOfRows;i++){
			for(int j=0; j<numberOfColumns;j++){
				System.out.print(matrix[i][j]+ " ");
				
			}
			System.out.println();
			
		}
		ZeroMatrixMaker obj = new ZeroMatrixMaker();
		matrixZerowed = obj.zeroMaker(matrix);
		
		System.out.println("\nZerowed Matrix:\n");
		for(int i =0; i<numberOfRows;i++){
			for(int j=0; j<numberOfColumns;j++){
				System.out.print(matrixZerowed[i][j]+ " ");
				
			}
			System.out.println();
			
		}
	}
	
	int[][] zeroMaker(int[][] matrix){
		
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		for(int i = 0; i < row.length; i++){
			for(int j = 0; j < column.length; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		for(int i = 0; i < row.length; i++){
			if(row[i]) nullifyRow(matrix, i);
		}
		
		for(int i = 0; i < column.length; i++){
			if(column[i]) nullifyColumn(matrix, i);
		}
		
		return matrix;
	}
	
	void nullifyRow(int[][] matrix, int row){
		for(int j = 0; j < matrix[0].length; j++){
			matrix[row][j] = 0;
		}
	}
	
	void nullifyColumn(int[][] matrix, int column){
		for(int j = 0; j < matrix.length; j++){
			matrix[j][column] = 0;
		}
	}
		
}
