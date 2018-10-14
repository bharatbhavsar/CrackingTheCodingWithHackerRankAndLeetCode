package com.arraysAndStrings;
/**
 * This is temporary work space where I use this to try something code syntax, 
 * temporary checking of code, etc. No problem or its solution in here.
 * @author Rohan
 *
 */


public class Temp {

	public static void main(String[] args){
		
		StringBuffer[] s = new StringBuffer[5];
		s[0].append("Hallo, world");
		System.out.println(s[0]);
	}
	
	
	
	private static void getKey(String pkey) {
		
		// 251220825122082
		//8251220
		
		for(int i = pkey.length()-1; i >=0; i--){
			
			for(int j = i-1; j >= 0; j--){
				
				int k = i;
				
				while(pkey.charAt(k)== pkey.charAt(j)){
					continue;
				}
					
				
			}
		}
		
		
		
	}


	static String findKey(String last){
		String orig = "Your friend, Alice";
		String res="";
		for(int i=0; i<orig.length(); ++i){
			if(i!=4 && i!=11 && i!=12){
				int or=orig.charAt(i);
				int la=last.charAt(i);
				int r=0;
				while(or!=la){
					or++;
					r++;
					if(or=='z'){
						or='a'-1;
					}
					if(or=='Z'){
						or='A'-1;
					}
					
					
				}
				res+=r;
			}
		}
		
		return res;
	}
	
	static String getString(String encrypted_message){
		int[] key = {8,2,5,1,2,2,0};
		StringBuilder res = new StringBuilder();
		int key_i = 0;
		for(int i=0; i<encrypted_message.length(); ++i){
			if((encrypted_message.charAt(i)>='a' && encrypted_message.charAt(i)<='z')||
					(encrypted_message.charAt(i)>='A' && encrypted_message.charAt(i)<='Z')){
				int or=encrypted_message.charAt(i);
				int r=0;
				while(r<key[key_i]){
					or--;
					r++;
					if(or=='a'-1){
						or='z';
					}
					if(or=='A'-1){
						or='Z';
					}
				}
				key_i++;
				if(key_i==7){
					key_i=0;
				}
				res.append((char)or);
			}else{
				res.append(encrypted_message.charAt(i));
			}
		}
		return res.toString();
	}
}
