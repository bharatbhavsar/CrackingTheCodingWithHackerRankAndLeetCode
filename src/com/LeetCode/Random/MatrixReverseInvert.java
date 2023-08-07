package com.LeetCode.Random;

/*
 * 
Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.

For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

For example, inverting [0,1,1] results in [1,0,0].
 

Example 1:

Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 

Constraints:

n == image.length
n == image[i].length
1 <= n <= 20
images[i][j] is either 0 or 1.
 * 
 */

import java.util.*;

public class MatrixReverseInvert {
	public static int[][] flipAndInvertImage(int[][] image) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < image.length;i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j < image[0].length; j++){
                temp.add(0,image[i][j]);
            }
            res.add(temp);
        }
        
        for(ArrayList<Integer> temp : res){
            for(int i = 0; i < temp.size(); i++){
                if(temp.get(i) == 1)
                    temp.set(i, 0);
                else
                    temp.set(i,1);
            }
        }
        int[][] resFinal = new int[res.size()][];
        for(int i = 0; i < res.size(); i++){
            resFinal[i] = res.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        
        return resFinal;
    }
	
	public static int[][] flipAndInvertImage2(int[][] image) {
        for(int i = 0; i < image.length; i++){
            for(int j = 0, k = image[i].length-1; j<=k; j++, k--){
                int temp = image[i][j];
                image[i][j] = image[i][k];
                image[i][k] = temp;
            }
        }
        for(int i = 0; i < image.length; i++){
            for(int j = 0;  j< image[i].length; j++){
                if(image[i][j]==1)
                    image[i][j]=0;
                else
                    image[i][j]=1;
            }
        }
        return image;
    }
	
	public static void main(String[] args) {
		int[][] sampleInput = {{1,1,0},{1,0,1},{0,0,0}};
		
		System.out.println(Arrays.deepToString(flipAndInvertImage(sampleInput)));
		System.out.println(Arrays.deepToString(flipAndInvertImage2(sampleInput)));
	}
}
