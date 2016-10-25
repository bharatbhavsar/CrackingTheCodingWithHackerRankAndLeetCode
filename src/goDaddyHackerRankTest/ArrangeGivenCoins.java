package goDaddyHackerRankTest;

public class ArrangeGivenCoins {

	public static void main(String[] args){
		long[] arr = {452864,985758965,8,12,45,324,556,123,1234,324,125367};
		arrangeCoins(arr);
	}
	
	static void arrangeCoins(long[] array){
	    for(int i = 0; i < array.length; i++){
	        System.out.println(arrangeCoins(array[i]));
	    }
	}

	static long arrangeCoins(long number){
		
		//(-1+sqroot(1+4*2*number))/2
		long result = (long)(-1 + Math.sqrt(1+ 4*2 * number)) / 2;
		return result;
	}

}
