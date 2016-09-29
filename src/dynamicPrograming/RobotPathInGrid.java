/**
 * Imagine a robot sitting on the upper left comer of an X by Y grid. The robot can only
 * move in two directions:right and down. How many possible paths are there for the
 * robot to go from (0, 0) to (X, Y)?
 * 
 * FOLLOW UP
 * 
 * Imagine certain spots are "off limits," such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom right.
 * 
 */

package dynamicPrograming;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class RobotPathInGrid {

	static ArrayList<Point> getPath(boolean[][] maze){
		if(maze==null || maze.length == 0){
			return null;
		}
		ArrayList<Point> path = new ArrayList<Point>();
		HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
		int lastRow = maze.length-1;
		int lastCol = maze[0].length-1;
		if(getPath(maze, lastRow, lastCol, path, cache)){
			return path;
		}
		return null;
		
	}
	
	static boolean getPath(boolean[][] maze, int lastRow, int lastCol, 
			ArrayList<Point> path, HashMap<Point, Boolean> cache){
		if(lastCol<0 || lastRow<0 || !maze[lastRow][lastCol]){
			return false;
		}
		Point p = new Point(lastRow, lastCol);
		
		if(cache.containsKey(p)){
			return cache.get(p);
		}
		boolean isAtOrigin = (lastRow==0) && (lastCol==0);
		boolean success = false;
		
		if(isAtOrigin || getPath(maze, lastRow, lastCol-1, path, cache) || 
				getPath(maze, lastRow-1, lastCol, path, cache)){
			path.add(p);
			success = true;
		}
		cache.put(p, success);
		return success;
	}
}
