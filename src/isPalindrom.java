import java.util.Scanner;

public class isPalindrom {
	
static boolean isThisPalindrom(String s){
		
		
		int[] characters = new int[26];
		//StringBuilder thisString = new StringBuilder();
		for(int i = 0; i<s.length();++i){
			if((int)s.charAt(i) >= 97 && (int)s.charAt(i)<=122 ){
				characters[(int)s.charAt(i) - 97 ]++;
			}
		}
		boolean oddFound = false;
		for(int count : characters){
			if(count%2 == 1){
				if(oddFound){
					return false;
				}
				oddFound = true;
			}
		}
		return true;
	}
	
	static boolean isPalindromePossible(String s){
		int[] characterArray = new int[Character.getNumericValue('z') - Character.getNumericValue('a')];
		int countOdd = 0;
		for (int c: s.toCharArray()){
			//int character = (int)c;
			if(c >= 97 && c<=122 ){
				characterArray[c - 97]++;
				if(characterArray[c - 97] % 2 == 1){
					countOdd++;
				}else{
					countOdd--;
				}
			}
		}
		return countOdd <=1;
	}
	
	public static void main(String[] args){
		String s;
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("Please enter the line: ");
		s = in.nextLine();
		s = s.trim();
		s = s.toLowerCase();
		
		System.out.println("Is given string palindrom? (true/alse): " + isThisPalindrom(s));
		
		System.out.println("Is given string palindrom? (true/alse): " + isPalindromePossible(s));
		
	}
}
