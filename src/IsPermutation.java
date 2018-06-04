import java.util.*;
public class IsPermutation {

	public static void main (String[] args){
		System.out.println("Result:" + inPermutation("rohan","roahn"));
	}
	
	static boolean inPermutation(String s1, String s2){
		if (s1.length() != s2.length()) return false;
		
		Map<Character, Integer> mp = new HashMap<Character, Integer>();
		
		for(int i=0; i<s1.length(); i++){
			if(!mp.containsKey(s1.charAt(i))){
				mp.put((Character) s1.charAt(i), (Integer) 1);
			}else{
				mp.put((Character)s1.charAt(i), mp.get((Character)s1.charAt(i)) + (Integer)1);
			}
		}
		for(int i=0; i<s2.length(); i++){
			if(!mp.containsKey((Character)s2.charAt(i))) {
				return false;
			}else{
				mp.put((Character)s2.charAt(i), mp.get((Character)s2.charAt(i)) - (Integer)1);
				System.out.println(mp.get((Character)s2.charAt(i)));
				if (mp.get((Character)s2.charAt(i)) < (Integer)0) return false;
			}
		}
		
		return true;
	}
}
