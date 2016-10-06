package ipSoftTest;

public class FindMissingWords {

	static String[] missingWords(String s, String t) {

        //convert into string array
        String[] ar1 = s.split(" ");
        String[] ar2 = t.split(" ");
        
        int p1 =0, p2 = 0, k =0;
        String[] out = new String[ar1.length - ar2.length]; // array of Missing words need to find
        
        //Scan both array to find missing words.
        while(p1 < ar1.length && p2 < ar2.length){
            if(ar1[p1].equals(ar2[p2])){
                p1++;
                p2++;
            }else{
                out[k] = ar1[p1];
                p1++;
                k++;
            }
        }
        
        if(p1 <= ar1.length-1){
            while(p1 != ar1.length){
                out[k] = ar1[p1];
                p1++;
                k++;
            }
        }
        
        return out;
    }
}
