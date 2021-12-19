package com.practice1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindIfNamePresentInNumber {
	/*
	 * Find if given name present in phonenumber
	 * Ex: 
	 * input:
	 * number: int
	 * list/ array of strings
	 * 
	 * output: names in number
	 * 
	 * example: 
	 * phone# : "3662277"
	 * ListOfNames : ["foo", "bar", "baz", "foobar", "emo", "cap", "car", "cat"]
	 * 
	 * Output: ["bar", "cap", "car", "emo", "foo", "foobar"]
	 * 
	 * -------------------
	 * | 1   |  2  |  3  |
	 * |     | abc | def |
	 * -------------------
	 * |  4  |  5  |  6  |
	 * | ghi | jkl | mno |
	 * -------------------
	 * |  7  |  8  |  9  |
	 * |pqrs | tuv | wxyz|
	 * -------------------
	 *       |  0  |
	 *       |     |
	 *       -------
	 */
	
	private static final Map<Character, Integer> myMap = new HashMap<>();
    static {
        myMap.put('a', 2);
        myMap.put('b', 2);
        myMap.put('c', 2);
        myMap.put('d', 3);
        myMap.put('e', 3);
        myMap.put('f', 3);
        myMap.put('g', 4);
        myMap.put('h', 4);
        myMap.put('i', 4);
        myMap.put('j', 5);
        myMap.put('k', 5);
        myMap.put('l', 5);
        myMap.put('m', 6);
        myMap.put('n', 6);
        myMap.put('o', 6);
        myMap.put('p', 7);
        myMap.put('q', 7);
        myMap.put('r', 7);
        myMap.put('s', 7);
        myMap.put('t', 8);
        myMap.put('u', 8);
        myMap.put('v', 8);
        myMap.put('w', 9);
        myMap.put('x', 9);
        myMap.put('y', 9);
        myMap.put('z', 9);
    }

	
	public String[] names_present(String ph_number, String[] name_array){
		ArrayList<String> res = new ArrayList<String>();
		for(int i =0; i < name_array.length; i++){
			StringBuilder s = new StringBuilder();
			for(int j=0; j < name_array[i].length(); j++){
				s.append(String.valueOf(myMap.get(name_array[i].charAt(j))));				
			}
			if (ph_number.contains(s.toString())){
				res.add(name_array[i]);
			}
		}
			
		String[] result = new String[res.size()];
		return res.toArray(result);
	}
	
	public static void main(String[] args){
		String ph_number = "3662277";
		String[] name_array = {"foo", "bar", "baz", "foobar", "emo", "cap", "car", "cat"};
		
		FindIfNamePresentInNumber my_obj = new FindIfNamePresentInNumber();
		String[] reStrings = my_obj.names_present(ph_number, name_array);
		Arrays.sort(reStrings);
		System.out.println(Arrays.toString(reStrings));
	}
}
