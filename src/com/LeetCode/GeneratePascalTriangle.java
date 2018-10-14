/**
 * Given numRows, generate the first numRows of Pascal's triangle.

	For example, given numRows = 5,
	Return
	
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]

 */

package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GeneratePascalTriangle {

	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //BaseCase
        if(numRows<=0){
            return result;
        }
        int i=1;
        while(i<=numRows){
            //if its first row of triangle
        	if(i==1){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(1);
                result.add(temp);
            }else{ //for row number greater than 1
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for(int j=1; j<=i; j++){
                	//if its first or last element of row
                    if(j==1 || j==i){
                        temp.add(1);
                    }else{ //for intermediate element of row 
                        temp.add(result.get(i-2).get(j-2) + result.get(i-2).get(j-1));
                    }
                }
                result.add(temp);
            }
            i++;
        }
        return result;
    }
}
