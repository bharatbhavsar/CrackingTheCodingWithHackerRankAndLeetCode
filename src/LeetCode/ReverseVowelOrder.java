/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
	
	Example 1:
	Given s = "hello", return "holle".
	
	Example 2:
	Given s = "leetcode", return "leotcede".
	
	Note:
	The vowels does not include the letter "y".
 */


package LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReverseVowelOrder {

	public static void main(String[] args){
		System.out.println(reverseVowelsSlow("is the you"));
		System.out.println(reverseVowelsFaster("is the you"));
	}
	
	
	/**
	 * This is slow version which requires 2 pass to the string.
	 * Therefore runtime is 2n where n is length of string.
	 * 
	 * We use stack here to reverse the order of vowels as they appear.
	 * Stack size is number of vowels we have in string.
	 * therefore max size is length of string for the stack.
	 * @param s
	 * @return
	 */
	public static String reverseVowelsSlow(String s) {
       Stack<Character> myVow = new Stack<Character>();
       
       for(int i=0; i<s.length(); i++){
           if(isVowel(s.charAt(i))){
               myVow.push(s.charAt(i));
           }
       }
       StringBuilder result = new StringBuilder();
       
       for(int i=0; i<s.length(); i++){
           if(isVowel(s.charAt(i))){
               result.append(myVow.pop());
           }else{
               result.append(s.charAt(i));
           }
       }
       
       return result.toString();
    }
    
    public static boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
            return true;
        }else{
            return false;
        }
    }
	    
	    
    /**
     * This is faster version as this uses only single pass of string.
     * Therefore runtime is n.
     * 
     * extra space for this is also fixed and not like the stack we used in above solution.
     * This set size is fixed to 10. Which is constant.
     * 
     * @param s
     * @return
     */
    public static String reverseVowelsFaster(String s) {
        Set<Character> myVow = new HashSet<Character>();
        myVow.add('a');
        myVow.add('e');
        myVow.add('i');
        myVow.add('o');
        myVow.add('u');
        myVow.add('A');
        myVow.add('E');
        myVow.add('I');
        myVow.add('O');
        myVow.add('U');
        
        char[] result = s.toCharArray();
        
        int i=0;
        int j=s.length()-1;
        
        while(i<j){
            if(!myVow.contains(result[i])){
                i++;
                continue;
            }
            if(!myVow.contains(result[j])){
                j--;
                continue;
            }
            
            char c = result[i];
            result[i]=result[j];
            result[j]=c;
            i++;
            j--;
        }
        
        return new String(result);
     }
}
