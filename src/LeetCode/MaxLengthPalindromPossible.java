/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

	This is case sensitive, for example "Aa" is not considered a palindrome here.
	
	Note:
	Assume the length of given string will not exceed 1,010.
	
	Example:
	
	Input:
	"abccccdd"
	
	Output:
	7
	
	Explanation:
	One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

package LeetCode;

import java.util.HashSet;

public class MaxLengthPalindromPossible {

	public static void main(String[] args){
		long start = System.nanoTime();
		System.out.println(longestPalindrome1("abccdssdfrrderksderfffedssrwefdta"));
		long end = System.nanoTime();
		System.out.println("First: " + (end-start));
		start = System.nanoTime();
		System.out.println(longestPalindrome2("abccdssdfrrderksderfffedssrwefdta"));
		end = System.nanoTime();
		System.out.println("Second: " + (end-start));
	}
	
	public static int longestPalindrome2(String s){
		int[] low = new int[26];
        int[] up = new int[26];
        boolean lowOdd = false;
        boolean upOdd = false;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                low[s.charAt(i)-'a']++;
            }else{
                up[s.charAt(i)-'A']++;
            }
        }
        
        int res=0;
        for(int i=0; i<26; i++){
            if(low[i]%2==0){
                res+=low[i];
            }else{
                res+=low[i]-1;
                lowOdd = true; 
            }
        }
        for(int i=0; i<26; i++){
            if(up[i]%2==0){
                res+=up[i];
            }else{
                res+=up[i]-1;
                upOdd = true;
            }
        }
        return res + (lowOdd || upOdd ? 1 : 0);
      
	}
	
	public static int longestPalindrome1(String s) {
	       
        HashSet<Character> ch = new HashSet<Character>();
        int res = 0;
        for(int i=0; i<s.length(); ++i){
            if(ch.contains(s.charAt(i))){
                res+=2;
                ch.remove(s.charAt(i));
            }else{
                ch.add(s.charAt(i));
            }
            
        }
        if(ch.isEmpty()){
            return res;
        }else{
            return res+1;
        }
    }
}
