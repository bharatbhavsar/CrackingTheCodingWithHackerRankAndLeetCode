package com.ipSoftTest;

import java.util.HashSet;
import java.util.Set;

public class FindFirstRepeatedWord {

	static String firstRepeatedWord(String s) {

        String[] t = s.split(" ");
        Set<String> set = new HashSet<String>();
        //This temp string is to update repeated word which appears first.
        String temp=null;
        
        //scan array backward and update temp string when it is already present in set 
        //as we want first word in sentence which was repeated.
        for(int i=t.length-1; i>=0; --i){
            if(set.contains(t[i])){
                temp=t[i];
                
            }else{
                set.add(t[i]);
            }
        }
        return temp;

    }
}
