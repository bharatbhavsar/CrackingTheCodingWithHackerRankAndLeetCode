package amazonOnline;

	public class GCD {
		 
	    public static int findGcd(int... numbers) {
	 
	        //Find the smallest integer in the number list
	         
	        int smallest = numbers[0];
	 
	        for (int i = 1; i < numbers.length; i++) {
	            if (numbers[i] < smallest) {
	                smallest = numbers[i];
	            }
	        }
	 
	        //Find the GCD
	        while (smallest > 1) {
	             
	            int counter = 0;
	            int modTot = 0;
	             
	            while (counter < numbers.length) {
	 
	                modTot += numbers[counter] % smallest;
	                counter++;
	 
	            }
	 
	            if (modTot == 0) {
	                //Return the gcd if any
	                return smallest;
	            }
	 
	            //System.out.print(" "+ smallest);
	            smallest--;
	           
	        }
	        //return -1 if there is no gcd
	        return -1;
	    }
	    /*
	    int GCD(int a, int b){
            if(b==0) return a;    
            return GCD(b, a%b);
        }

        int LCM(int a, int b){
            return a*b/GCD(a,b);
        }

        int LCM2(int *a, int i, int n){
            if(i == n){
                return 1;
            }
            
            return LCM(a[i],LCM2(a,i+1,n));
        }*/
	   
	    public static void main(String[] x) {
	        System.out.println("The GCD of 15 18 42 108 : "+GCD.findGcd(new int[]{4,8,12}));
	    }
	}
