package com.goDaddyHackerRankTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringPermutations {

	
	public static String[] getSubset(String s){
		ArrayList<String> result = new ArrayList<String>();
		if(s == null){
			return result.toArray(new String[0]);
		}
		
		for(int i = 0; i < s.length(); i++){
			ArrayList<String> temp = new ArrayList<String>();
			
				for(String list : result){
					
						temp.add(list);
				}
			
			
				for(int j=0; j<temp.size();++j){
					String s1=temp.get(j);
					temp.remove(j);
					StringBuilder sb = new StringBuilder(s1);
					sb.append(s.charAt(i));
					s1=sb.toString();
					temp.add(j, s1);
				}
			
			String single = new String(""+s.charAt(i));
			temp.add(single);
			
			result.addAll(temp);
			
		}
		Collections.sort(result);
		return result.toArray(new String[result.size()]);
	}
	
	public static void main(String[] args){
		
		String[] res = getSubset("abcd");
		for(String s:res){
			System.out.println(s);
		}
		System.out.println(res.length);
	}
}
