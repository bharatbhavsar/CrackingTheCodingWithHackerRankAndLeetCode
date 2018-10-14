package com.arraysAndStrings;
import java.util.Scanner;

public class MatrixRotationNXN {

	public static void main(String[] args){
		int[][] matrix;
		Scanner in = new Scanner(System.in);
		int numberOfRows = in.nextInt();
		matrix = new int[numberOfRows][numberOfRows];
		int[][] result = new int[numberOfRows][numberOfRows];
		for(int i =0; i<numberOfRows;i++){
			for(int j=0; j<numberOfRows;j++){
				matrix[i][j]=in.nextInt();
				result[i][j]=matrix[i][j];
			}
		}
		
		System.out.println("\nOriginal Matrix:\n");
		for(int i =0; i<numberOfRows;i++){
			for(int j=0; j<numberOfRows;j++){
				System.out.print(matrix[i][j]+ " ");
				
			}
			System.out.println();
			
		}
		MatrixRotationNXN obj = new MatrixRotationNXN();
		matrix = obj.matrixRotationRight(matrix, numberOfRows);
		System.out.println("\nRight Rotated Matrix:\n");
		for(int i =0; i<numberOfRows;i++){
			for(int j=0; j<numberOfRows;j++){
				System.out.print(matrix[i][j]+ " ");
				
			}
			System.out.println();
			
		}
		
		result = obj.matrixRotationLeft(result, numberOfRows);
		System.out.println("\n Left Rotated Matrix:\n");
		for(int i =0; i<numberOfRows;i++){
			for(int j=0; j<numberOfRows;j++){
				System.out.print(result[i][j]+ " ");
				
			}
			System.out.println();
			
		}
	}
	int[][] matrixRotationRight(int[][] matrix, int n){
		for(int layer =0; layer < n/2; ++layer){
			int first = layer;
			int last = n-1-layer;
			for(int i=first; i<last;i++){
				int offSet = i-first;
				int top = matrix[first][i];
				matrix[first][i]=matrix[last-offSet][first];
				matrix[last-offSet][first]=matrix[last][last-offSet];
				matrix[last][last-offSet]=matrix[i][last];
				matrix[i][last]=top;
			}
		}
		return matrix;
	}
	
	int[][] matrixRotationLeft(int[][] matrix, int n){
		for(int layer=0; layer<n/2; layer++){
			int first = layer;
			int last = n-1-layer;
			for(int i=first; i<last; i++){
				int offSet = i-first;
				
				int top = matrix[i][first];
				matrix[i][first] = matrix[i][last];
				matrix[i][last] = matrix [last][last-offSet];
				matrix[last][last-offSet] = matrix[last-offSet][first];
				matrix[last-offSet][first]= top;
			}
		}
		return matrix;
	}
}
