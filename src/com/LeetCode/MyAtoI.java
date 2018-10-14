package com.LeetCode;
import java.util.Scanner;

public class MyAtoI {

	public static void main(String[] args){
		String given;
		Scanner in = new Scanner(System.in);
		given = in.nextLine();
		MyAtoI obj = new MyAtoI();
		System.out.println("Converted string to int is: " + obj.myAtoi(given));
		in.close();
	}
	
	int myAtoi(String str) {
		int first=0;
	    int walker=0;
	    int zero = Character.getNumericValue('0');
	    int nine = Character.getNumericValue('9');
	    int INT_MAX = 2147483647;
	    int INT_MIN = -2147483648;
	    StringBuilder tempString = new StringBuilder();
	      
	    while(walker<str.length() && str.length()>0){
	        if(str.charAt(walker)!=' '){
	            first = walker;
	            break;
	        }
	        walker++;
	    }
	    int sign = 1;
	    for(int i = first; i<str.length(); ++i){
	    	if(i == first && str.charAt(i) == '+'){
	             sign = 1;
	    	}else if(i == first && str.charAt(i) == '-'){
	    		sign = -1;  
	    	}else if(Character.getNumericValue(str.charAt(i)) >= zero && Character.getNumericValue(str.charAt(i)) <= nine){
	    		tempString.append(str.charAt(i));
	    	}else{
	    		break;
	    	}
	    }
	      
	    String myReturn = tempString.toString();
	    System.out.println(myReturn);
	    long result = 0;
	    for (int i =0; i < myReturn.length(); i++){
	        char digit = (char)(myReturn.charAt(i) - '0');
	        result += (digit * Math.pow(10, (myReturn.length() - i - 1)));
	    }
	    result = result*sign;
        if(result >= INT_MAX){
            return INT_MAX;
        }else if(result <= INT_MIN){
            return INT_MIN;
        }else{
            return (int)result;
        }
	}
}
