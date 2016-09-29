/**
 * Given two arrays, write a function to compute their intersection.

	Example:
	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
	
	Note:
	Each element in the result should appear as many times as it shows in both arrays.
	The result can be in any order.
	
	Follow-up: what if arrays are sorted?
	
	2 methods:
	intersect returns all elements i.e might return duplicates; USED ArrayList
	intersection returns distinct elements. USED Set
	
 */

package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class IntersectionOf2Arrays {

	public static void main(String[] args){
		int[] nums1 = {1,2,3,4,3,5,2,5,3};
		int[] nums2 = {2,3,4,1,3,5,6,7};
		int[] result =intersect(nums1,nums2);
		for(int i: result)
			System.out.print(i+" ");
		result =intersection(nums1,nums2);
		System.out.println();
		for(int i: result)
			System.out.print(i+" ");
	}
	public static  int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums1){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
     
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i: nums2){
            if(map.containsKey(i)){
                if(map.get(i)>1){
                    map.put(i, map.get(i)-1);
                }else{
                    map.remove(i);
                }
                list.add(i);
            }
        }
     
        int[] result = new int[list.size()];
        int i =0;
        while(i<list.size()){
            result[i]=list.get(i);
            i++;
        }
     
        return result;
    }
	
	public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> mySet = new HashSet<Integer>();
        for(int i=0; i<nums1.length; i++){
            if(!mySet.contains(nums1[i])){
                mySet.add(nums1[i]);
            }
        }
        HashSet<Integer> myResult = new HashSet<Integer>();
        for(int i=0; i<nums2.length; i++){
            if(mySet.contains(nums2[i])){
                if(!myResult.contains(nums2[i])){
                    myResult.add(nums2[i]);
                }
            }
        }
        int[] result = new int[myResult.size()];
        int i=0;
        for(Integer val : myResult){
            result[i++]=val;
        }
        return result;
    }
}

//Followup question: what if arrays are sorted:
//solution:
/**
 *
	 public int[] intersect(int[] nums1, int[] nums2) {
	    Arrays.sort(nums1);
	    Arrays.sort(nums2);
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    int p1=0, p2=0;
	    while(p1<nums1.length && p2<nums2.length){
	        if(nums1[p1]<nums2[p2]){
	            p1++;
	        }else if(nums1[p1]>nums2[p2]){
	            p2++;
	        }else{
	            list.add(nums1[p1]);
	            p1++;
	            p2++;
	 
	        }
	    }
	 
	    int[] result = new int[list.size()];
	    int i=0;
	    while(i<list.size()){
	        result[i]=list.get(i);
	        i++;
	    }
	    return result;
	} 
 */