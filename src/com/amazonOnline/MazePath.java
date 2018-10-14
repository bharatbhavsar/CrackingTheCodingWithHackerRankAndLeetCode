package com.amazonOnline;
public class MazePath{
	
    public static boolean visited[][];
    
    public static void init(int m, int n) {
        visited = new boolean[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				visited[i][j] = false;
			}
		}
    }
    
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public static int isPath(int[][] grid)
  {
    // INSERT YOUR CODE HERE
    int m = grid.length;
	int n = grid[0].length;
    init(m, n);
	return solveMazeUtil(grid, 0, 0, m, n);

  }
  // METHOD SIGNATURE ENDS
  
  public static int solveMazeUtil(int[][] grid, int x, int y, int m, int n) {
               
		if (x >= 0 && x < m && y >= 0 && y < n) {
			if(!visited[x][y]) {
				if (grid[x][y] == 9) {
					return 1;
				}
				visited[x][y] = true;
				// Check if maze[x][y] is valid
				if (grid[x][y] == 1) {
					/* Move forward in x direction */
					if (solveMazeUtil(grid, x + 1, y, m, n) == 1) {
						return 1;
					}
					
					if(solveMazeUtil(grid, x, y + 1, m, n) == 1) {
						return 1;
					}
					
					/*
					 * If moving in x direction doesn't give solution then Move down
					 * in y direction
					 */
					if(solveMazeUtil(grid, x - 1, y , m, n) == 1) {
						return 1;
					}
					
					if (solveMazeUtil(grid, x, y - 1, m, n) == 1) {
						return 1;
					}
					
					
					
					/*
					 * If none of the above movements work then BACKTRACK: unmark
					 * x,y as part of solution path
					 */
					return 0;
				}
				return 0;
			}
			return 0;
		}
		return 0;

	}
}