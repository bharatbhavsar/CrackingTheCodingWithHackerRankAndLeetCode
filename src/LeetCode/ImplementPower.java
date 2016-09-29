/**
 * Implement pow(x, n).
 */

package LeetCode;

public class ImplementPower {

	public static void main(String[] args){
		System.out.println("Power of 2.5 raised to 8 : " + myPow(2, -8));
	}
	
	public static double myPow(double x, int n){
		if(n<0){
			return 1/power(x,n);
		}else{
			return power(x,n);
		}
	}
	
	public static double power(double x, int n){
		if(n==0){
			return 1;
		}
		
		double num = power(x, n/2);
		
		if(n%2==0){
			return num * num;
		}else{
			return num * num * x;
		}
	}
}
