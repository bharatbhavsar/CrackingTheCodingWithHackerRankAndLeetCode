package ipSoftTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class TelephonicInterview {

	/**
	 * Given a list of objects, returns the last object in the list that is an instance of type Bar.
	 * @param stuff the list of objects
	 * @return an object of type Bar
	 * @throws NoSuchBarException if there is no Bar in the list
	 */
	public Bar getLastBar(List<Object> stuff) throws NoSuchBarException{
	    if(stuff==null || stuff.size()==0){
	        throw new NoSuchBarException();
	    }
	    
	    Bar temp = new Bar();
	    
	    for(int i=0; i<stuff.size();i++){
	        if(stuff.get(i) instanceof Bar){
	            temp = (Bar) stuff.get(i);
	        }
	    }
	    
	    if(temp==null){
	        throw new NoSuchBarException();
	    }
	    return temp;
	}


	/**
	* This method receives an array with positive integers, where all values in the array are repeated - except for one which is unique.
	* Return the unique element in the array.
	*
	* @param intArray[] array of ints
	* @return the non-repeated int
	*
	* e.g.
	* int[] arr = {1,2,3,5,6,3,2,5,1,32,32,3,4,4,1}
	* int nonRepeated = findNonRepeatedInt(arr);
	* System.out.println(nonRepeated); // prints 6
	*
	*/
	public int findNonRepeatedInt(int[] intArray) {

	    HashMap<Integer,Integer> myMap = new HashMap<Integer,Integer>();
	    int res=0;
	    for(int i=0; i<intArray.length; ++i){
	        if(!myMap.containsKey(intArray[i])){
	            myMap.put(intArray[i],1);
	        }else{
	            myMap.put(intArray[i],myMap.get(intArray[i])+1);
	        }
	    }
	    Set<Entry<Integer, Integer>> set = myMap.entrySet();
	    for(Entry<Integer, Integer> i: set){
	        if(myMap.get(i)==1){
	            res=i.getKey().intValue();
	        }
	    }
	    return res;
	}

}

class Bar{
	
}
