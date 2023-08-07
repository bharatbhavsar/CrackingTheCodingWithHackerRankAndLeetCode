/*
 * Given an array of intervals where 
 * intervals[i] = [starti, endi], 
 * merge all overlapping intervals, and return an array of 
 * the non-overlapping intervals that cover all the intervals 
 * in the input.
 * 
 * Link:
 * 
 * https://leetcode.com/problems/merge-intervals/description/
 * 
 */

package com.LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> myList = new ArrayList<>();
        for(int[] interval : intervals){
            if(myList.isEmpty() || interval[0] > myList.get(myList.size()-1)[1]){
                myList.add(interval);
            } else {
                myList.get(myList.size()-1)[1] = Math.max(interval[1], myList.get(myList.size()-1)[1]);
            }
        }
        return myList.toArray(new int[myList.size()][]);
    }

}
