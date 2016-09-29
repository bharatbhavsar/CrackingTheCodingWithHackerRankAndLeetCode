package LeetCode;

public class CountAndSay {

	public static void main(String[] args){
		int n = 4;
		String prev;
        int intCount = 1;
        String currentInt = "1";
        for(int i = 1; i <= n; i++){
            StringBuilder current = new StringBuilder();
            if(i==1){
                
                current.append("1");
                currentInt = current.toString();
                
            }else{
                prev = currentInt;
                
                for(int j = 0; j < prev.length(); ++j){
                    if((j+1) != prev.length() && prev.charAt(j+1) == prev.charAt(j)){
                        intCount++;
                    }else{
                        current.append(intCount);
                        current.append(prev.charAt(j));
                        intCount=1;
                    }
                }
                
                currentInt = current.toString();
                
            }
            
        }
        System.out.println(currentInt);;
    }
	
}
