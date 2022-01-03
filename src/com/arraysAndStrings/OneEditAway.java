package com.arraysAndStrings;
import java.util.Scanner;

public class OneEditAway {

	public static void main(String[] args){
		String first, second;
		boolean isOneEditAway = false;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter first string: \n");
		first = in.nextLine().toLowerCase();
		System.out.println("\nEnter second string: \n");
		second = in.nextLine().toLowerCase();
		in.close();
		OneEditAway obj = new OneEditAway();
		if(first.length()==second.length()){
			isOneEditAway=obj.oneEditReplace(first, second);
		}
		if(first.length()+1 == second.length()){
			isOneEditAway=obj.oneEditInsert(first, second);
		}
		if(first.length()-1 == second.length()){
			isOneEditAway=obj.oneEditInsert(second, first);
		}
		System.out.println("These 2 strings are one edit away (true/ false): " + isOneEditAway);
		System.out.println("These 2 strings are one edit away (true/ false): " + obj.oneEdit(first, second));
		
	}
	
	boolean oneEditReplace(String first, String second){
		boolean foundDiff = false;
		for(int i =0; i < first.length(); ++i){
			if(first.charAt(i)!=second.charAt(i)){
				if(foundDiff){
					return false;
				}
				foundDiff = true;
			}
		}
		return true;
	}
	
	boolean oneEditInsert(String first, String second){
		int index1 = 0, index2 = 0;
		while(index2 < second.length() && index1 < first.length()){
			if(first.charAt(index1)!=second.charAt(index2)){
				if(index1!=index2){
					return false;
				}
				index2++;
			}else{
				index1++;
				index2++;
			}
		}
		return true;
	}
	
	/**
	 * This method is combination of above two methods 
	 * where you don't have to take care of string lengths.
	 * Just pass the give 2 strings.
	 * 
	 * @param s1 --> first string
	 * @param s2 --> second string
	 * @return
	 */
	
	boolean oneEdit(String s1, String s2){
		if(Math.abs(s1.length()-s2.length())>1){
			return false;
		}
		
		String first = s1.length()<s2.length() ? s1 : s2;
		String second = s1.length()<s2.length() ? s2 : s1;
		
		int index1=0, index2=0;
		boolean found = false;
		while(index2<second.length() && index1<first.length()){
			if(first.charAt(index1)!=second.charAt(index2)){
				if(found){
					return false;
				}
				found=true;
				if(first.length()<second.length()){
					index2++;
				}
			}else{
				index1++;
				index2++;
			}
		}
		return true;
	}
}
