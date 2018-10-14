package com.amazonOnline;


public class activeInactiveCells {
	boolean active = true;
	boolean inactive = false;
	int[] cellCompete(int[] cells,int days)
	{
		int[] result = null;
		for(int i=0;i<days;i++){
			result = new int[8];
			for(int j=0;j<cells.length;j++){
				boolean previousNeighbour , nextNeighbour;
				if(j==0){
					previousNeighbour = inactive;
					nextNeighbour = cells[j+1] == 1 ? active : inactive;
				}else if(j == (cells.length -1)){
					previousNeighbour = cells[j-1] == 1 ? active : inactive;
					nextNeighbour = inactive;
				}else{
					previousNeighbour = cells[j-1] == 1 ? active : inactive;
					nextNeighbour = cells[j+1] == 1 ? active : inactive;
				}
				if(previousNeighbour == nextNeighbour){
					result[j] = 0;
				}else{
					result[j] = 1;
				}
			}
			cells = result;
		}
		return result;
	//write your code here
	} 
	//function signature ends
	public static void main(String[] args){
		int[] inp = {1,1,1,0,1,1,1,1};
		activeInactiveCells a = new activeInactiveCells();
		int[] result = a.cellCompete(inp,2);
		for(int i: result){
			System.out.print(i + " ");
		}
	}
}
