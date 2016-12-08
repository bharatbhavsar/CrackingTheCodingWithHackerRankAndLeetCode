package amazonOnline;
	public class LongestPallindromicSubString {
	    
	    public static String LPS(String s) {
	          int n = s.length();
	          int palindromeBeginsAt = 0;  
	          int max_len = 1; 
	          boolean palindrome[][] = new boolean[n][n];  
	          
	           
	          for (int i = 0; i < n; i++) {
	              palindrome[i][i] = true;
	          }
	          
	           
	          for (int i = 0; i < n-1; i++) {
	            if (s.charAt(i) == s.charAt(i+1)) {
	              palindrome[i][i+1] = true;
	              palindromeBeginsAt = i;
	              max_len = 2;
	            }
          }
	          
	           
	          for (int curr_len = 3; curr_len <= n; curr_len++) {
	            for (int i = 0; i < n-curr_len+1; i++) {
	              int j = i+curr_len-1;
	              if (s.charAt(i) == s.charAt(j)  
	                  && palindrome[i+1][j-1])  
	              {
	                palindrome[i][j] = true; 
	                palindromeBeginsAt = i;
	                max_len = curr_len;
	              }
	            }
	          }
	          return s.substring(palindromeBeginsAt, max_len + palindromeBeginsAt);
	        }
	
	    public static void main(String args[])
	    {
        System.out.println(LPS("banana" ));
	    }
	}