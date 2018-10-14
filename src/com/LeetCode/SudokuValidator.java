package com.LeetCode;

public class SudokuValidator {

	public static boolean isValidSudoku(char[][] board) {
        if(board==null || board.length !=9 || board[0].length!=9){
            return false;
        }
        
        //check rows
        for(int i=0; i<9; i++){
            boolean[] val = new boolean[9];
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    if(val[(int)(board[i][j]-'1')]){
                        return false;
                    }
                    val[(int)(board[i][j]-'1')]=true;
                }
            }
        }
        
        //check columns
        for(int i=0; i<9; i++){
            boolean[] val = new boolean[9];
            for(int j=0; j<9; j++){
                if(board[j][i]!='.'){
                    if(val[(int)(board[j][i]-'1')]){
                        return false;
                    }
                    val[(int)(board[j][i]-'1')]=true;
                }
            }
        }
        
        //check blocks
        for(int block=0; block<9; block++){ //select block
            boolean[] val = new boolean[9];
          //select rows
            for(int i=block/3*3; i<block/3*3+3; i++){ 
            	// select columns for loop is different
                for(int j=block%3*3; j<block%3*3+3; j++){ 
                    if(board[i][j]!='.'){
                    if(val[(int)(board[i][j]-'1')]){
                        return false;
                    }
                    val[(int)(board[i][j]-'1')]=true;
                }   
                }
            }
        }
        
        return true;
    }
}
