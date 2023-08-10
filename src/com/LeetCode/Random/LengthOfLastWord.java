package com.LeetCode.Random;

public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
        String myStr = s.trim();
        int res = 0;
        for(int i = myStr.length() - 1; i >= 0; i--){
            if(myStr.charAt(i) != ' '){
                res++;
            }else{
                break;
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
	}
}
