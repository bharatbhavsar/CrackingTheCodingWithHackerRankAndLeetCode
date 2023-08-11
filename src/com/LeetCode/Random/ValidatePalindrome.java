package com.LeetCode.Random;

public class ValidatePalindrome {
	
	public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = Character.toLowerCase(s.charAt(i));
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
                sb.append(c);
            }
        }
        
        String res = sb.toString();
        System.out.println(res);
        int start = 0;
        int end = res.length() - 1;
        while(start <= end){
            if(res.charAt(start) != res.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

}
