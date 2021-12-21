package com.arraysAndStrings;
import java.util.Scanner;

public class MatrixRotationMXN {

	public static void main(String[] args){
		int[][] matrix, matrix90Right, matrix90Left;
		Scanner in = new Scanner(System.in);
		int numberOfRows = in.nextInt();
		int numberOfColumns = in.nextInt();
		matrix = new int[numberOfRows][numberOfColumns];
		for(int i =0; i<numberOfRows;i++){
			for(int j=0; j<numberOfColumns;j++){
				matrix[i][j]=in.nextInt();
				
			}
			
		}
		in.close();
		System.out.println("\nOriginal Matrix:\n");
		for(int i =0; i<numberOfRows;i++){
			for(int j=0; j<numberOfColumns;j++){
				System.out.print(matrix[i][j]+ " ");
				
			}
			System.out.println();
			
		}
		MatrixRotationMXN obj = new MatrixRotationMXN();
		matrix90Right = obj.matrixRotation90Right(matrix, numberOfRows, numberOfColumns);
		matrix90Left = obj.matrixRotation90Left(matrix, numberOfRows, numberOfColumns);
		System.out.println("\n90 degree Right Rotated Matrix:\n");
		for(int i =0; i<numberOfColumns;i++){
			for(int j=0; j<numberOfRows;j++){
				System.out.print(matrix90Right[i][j]+ " ");
				
			}
			System.out.println();
			
		}
		System.out.println("\n90 degree Left Rotated Matrix:\n");
		for(int i =0; i<numberOfColumns;i++){
			for(int j=0; j<numberOfRows;j++){
				System.out.print(matrix90Left[i][j]+ " ");
				
			}
			System.out.println();
			
		}
	}
	
	int[][] matrixRotation90Right(int[][] matrix, int row, int column){
		int resRow = column;
		int resColumn = row;
		int[][] resMatrix = new int[resRow][resColumn];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				resMatrix[j][resColumn - 1 - i] = matrix[i][j];
			}
		}
		
		return resMatrix;
	}
	
	int[][] matrixRotation90Left(int[][] matrix, int row, int column){
		int resRow = column;
		int resColumn = row;
		int[][] resMatrix = new int[resRow][resColumn];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				resMatrix[resRow - 1 - j][i] = matrix[i][j];
			}
		}
		
		return resMatrix;
	}
}