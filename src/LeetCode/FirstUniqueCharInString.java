/**
 * Given a string, find the first non-repeating character in it and return it's index. 
 * If it doesn't exist, return -1.

	Examples:
	
	s = "leetcode"
	return 0.
	
	s = "loveleetcode",
	return 2.
	
	Note: You may assume the string contain only lowercase letters.
 
 */

package LeetCode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstUniqueCharInString {

	public static void main(String[] args){
		System.out.println(firstUniqChar("bharat"));
		System.out.println(firstUniqueChar("bharat"));
	}
	
	/**
	 * Analysis:
	 * Runtime: 2n
	 * Space: 1 (Fix size array)
	 * 
	 * where n is length of string.
	 * 
	 * @param s
	 * @return
	 */
	public static int firstUniqChar(String s) {
	    
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
	
	
	/**
	 * 
	 * Analysis:
	 * runtime: n + size of map = ~ n
	 * space: number of different characters in string. but max size is 26. fix.
	 * 
	 * @param s
	 * @return
	 */
	
	public static int firstUniqueChar(String s){
		
		Map<Character, Integer> myMap = new LinkedHashMap<Character, Integer>();
		for(char c: s.toCharArray()){
			myMap.put(c,myMap.containsKey(c)? myMap.get(c)+1 : 1);
		}
		
		for(Entry<Character, Integer> entry : myMap.entrySet()){
			if(entry.getValue()==1){
				return s.indexOf(entry.getKey());
			}
		}
		return -1;
	}
}
