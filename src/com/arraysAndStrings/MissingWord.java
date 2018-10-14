package com.arraysAndStrings;

public class MissingWord {

	static String[] missingWords(String s, String t) {

        String[] arr1 = s.split(" ");
        String[] arr2 = t.split(" ");
        
        int p1 =0, p2 = 0, k =0;
        String[] out = new String[arr1.length - arr2.length];
        while(p1 < arr1.length && p2 < arr2.length){
            if(arr1[p1].equals(arr2[p2])){
                p1++;
                p2++;
            }
            else
            {
                out[k] = arr1[p1];
                p1++;
                k++;
            }
            
        }
        
        if(p1 <= arr1.length-1){
            while(p1 != arr1.length){
                out[k] = arr1[p1];
                p1++;
                k++;
            }
        }
        
        return out;
    }
}
