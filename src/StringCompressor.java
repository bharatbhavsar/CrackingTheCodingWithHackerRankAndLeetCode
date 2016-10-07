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
		StringBuilder res = new StringBuilder();
		int count =0;
		for(int i =0; i<s.length();++i){
			count++;
			if(i+1>=s.length() || s.charAt(i) != s.charAt(i+1)){
				res.append(s.charAt(i));
				res.append(count);
				count = 0;
			}
		}
		return res.toString();
	}
}
