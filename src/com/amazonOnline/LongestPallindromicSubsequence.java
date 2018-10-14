package com.amazonOnline;


	
	public class LongestPallindromicSubsequence {
			    
			    public static int LPS(String s) {
			          int n = s.length();
			          int palindrome[][] = new int[n][n];  
			          
			           
			          for (int i = 0; i < n; i++) {
			              palindrome[i][i] = 1;
			          }
			          
			           
			          for (int curr_len = 2; curr_len <= n; curr_len++) {
			            for (int i = 0; i < n-curr_len+1; i++) {
			              int j = i+curr_len-1;
			              if (s.charAt(i) == s.charAt(j)) 
			              {
			                palindrome[i][j] = palindrome[i+1][j-1] + 2; 
			              }
			              else  
			              {
			                palindrome[i][j] = Math.max(palindrome[i+1][j], palindrome[i][j-1]);
			              }
			            }
			          }
			          
			          return palindrome[0][n-1];
			        }
			
			    public static void main(String args[])
			    {
			        System.out.println(LPS("GEEKS FOR GEEKS" ));
			    }
			}


