package ibmCodingChallenge;

public class StringReverser {

	public static void main(String[] args){
		String input="Teiluj Dna Oemor Morf - Eugatnom A Ton Hguoht Flesyht Tra Uoht";
		
		StringBuilder sb = new StringBuilder(input.toLowerCase());
		sb=sb.reverse();
		for(int i = 1; i < sb.length(); i++){
			if (sb.charAt(i-1) == ' '){
				String t = new String(Character.toString(sb.charAt(i))).toUpperCase();
				sb.setCharAt(i, t.charAt(0));
			}
		}
		sb.setCharAt(0, sb.substring(0,1).toUpperCase().charAt(0));
		System.out.println(sb.toString());
	}
}
