package amazonOnline;

public class Reverse {
	 public static int reverse(int n) {
	       int result = 0;
	       int rem;
	       while (n > 0) {
	           rem = n % 10;
	           n = n / 10;
	           result = result * 10 + rem;
	       }
	       return result;
	   }
}
