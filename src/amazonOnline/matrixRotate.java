package amazonOnline;

public class matrixRotate {
	
	public int[][] transpose(int[][] matrix,int m,int n){
		int[][] transpose = new int[n][m];
		for (int c = 0 ; c < m ; c++ )
	    {
	       for ( int d = 0 ; d < n ; d++ )               
	          transpose[d][c] = matrix[c][d];
	    }
		return transpose;
	}
	public void reverseRows(int[][] matrix, int m, int n){
		int lastIndex = n-1;
		for(int i=0;i<m;i++){
			for(int j=0;j<(n/2);j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][lastIndex - j];
				matrix[i][lastIndex - j] = temp;
			}
		}
	}
	public void reverseColumns(int[][] matrix, int m, int n){
		int lastIndex = m-1;
		for(int i=0;i<n;i++){
			for(int j=0;j<(m/2);j++){
				int temp = matrix[j][i];
				matrix[j][i] = matrix[lastIndex - j][i];
				matrix[lastIndex - j][i] = temp;
			}
		}
	}
	public int[][] rotateBy90CW(int[][] matrix,int m,int n){
		int[][] transposeMatrix = transpose(matrix,m,n);
		reverseRows(transposeMatrix,n,m);
		return transposeMatrix;
	}
	public int[][] rotateBy90ACW(int[][] matrix,int m,int n){
		int[][] transposeMatrix = transpose(matrix,m,n);
		reverseColumns(transposeMatrix,n,m);
		return transposeMatrix;
	}
	public int[][] rotateBy180CW(int[][] matrix,int m,int n){
		int[][] rotate90Matrix = rotateBy90CW(matrix,m,n);
		int[][] rotate180Matrix = rotateBy90CW(rotate90Matrix, rotate90Matrix.length, rotate90Matrix[0].length);
		return rotate180Matrix;
	}
	public int[][] rotateBy180ACW(int[][] matrix,int m,int n){
		int[][] rotate90Matrix = rotateBy90ACW(matrix,m,n);
		int[][] rotate180Matrix = rotateBy90ACW(rotate90Matrix, rotate90Matrix.length, rotate90Matrix[0].length);
		return rotate180Matrix;
	}
	public void printMatrix(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			System.out.print("\n");
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
		}
	}
	public static void main(String[] args){
		int[][] matrix = { {1,2},{4,5},{7,8}};
		matrixRotate m = new matrixRotate();
		System.out.println("Original matrix");
		m.printMatrix(matrix);
		System.out.println("\n\nResult matrix : Clockwise 90 rotation");
		int[][] result = m.rotateBy90CW(matrix, 3, 2);
		m.printMatrix(result);
		System.out.println("\n\nResult matrix : Anti-clockwise 90 rotation");
		result = m.rotateBy90ACW(matrix, 3, 2);
		m.printMatrix(result);
		System.out.println("\n\nResult matrix : Clockwise 180 rotation");
		result = m.rotateBy180CW(matrix, 3, 2);
		m.printMatrix(result);
		System.out.println("\n\nResult matrix : Anti-clockwise 180 rotation");
		result = m.rotateBy180ACW(matrix, 3, 2);
		m.printMatrix(result);
		
	}
	
}