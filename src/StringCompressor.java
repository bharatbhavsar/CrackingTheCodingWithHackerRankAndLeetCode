import java.util.Scanner;

public class StringCompressor {

	public static void main(String[] args){
		StringCompressor obj = new StringCompressor();
		
		String s;
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("Please enter the line: ");
		s = in.nextLine();
		
		System.out.println("Compressed String: " + obj.compressor(s));
	}
	
	String compressor(String s){
		StringBuilder returner = new StringBuilder();
		int count =0;
		for(int i =0; i<s.length();++i){
			count++;
			if(i+1>=s.length() || s.charAt(i) != s.charAt(i+1)){
				returner.append(s.charAt(i));
				returner.append(count);
				count = 0;
			}
		}
		return returner.toString();
	}
}
