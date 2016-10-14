package ibmCodingChallenge;

public class StringParser {

	public static void main(String[] args){
		String input = "(NP (NP (DT a) (NN boy)) (VP (VBG eating) (NP (NNS sausages))))";
		StringBuilder sb = new StringBuilder();
		StringBuilder buffer = new StringBuilder();

		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				buffer.setLength(0);
				continue;
			}
			if (input.charAt(i) == ')') {
				if (input.charAt(i - 1) != ')') {
					sb.append(buffer);
					sb.append(" ");
					buffer.setLength(0);
				}
			} else {
				buffer.append(input.charAt(i));
			}
		}
		System.out.println(sb.toString().trim());
	}
}
