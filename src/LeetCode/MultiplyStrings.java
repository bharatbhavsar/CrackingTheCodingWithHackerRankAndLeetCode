package LeetCode;

public class MultiplyStrings {

	public static void main(String[] args){
		System.out.println("Multiplication of  123 and 345 is: " + multiply("123", "345"));
	}
	public static String multiply(String num1, String num2) {
        String s1 = new StringBuilder(num1).reverse().toString();
        String s2 = new StringBuilder(num2).reverse().toString();
        
        int[] num = new int[num1.length() + num2.length()];
        
        for(int i = 0; i < num1.length(); i++){
            for(int j = 0; j < num2.length(); j++){
            	num[i+j] += (s1.charAt(i)-'0')*(s2.charAt(j)-'0'); 
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < num.length; i++){
            int mod = num[i]%10;
            int carry = num[i]/10;
            if(i+1<num.length){
                num[i+1] += carry;
            }
            result.insert(0, mod);
            
        }
        
        while(result.charAt(0)=='0' & result.length()>1){
            result.deleteCharAt(0);
        }
        
        return result.toString();
    }
}
