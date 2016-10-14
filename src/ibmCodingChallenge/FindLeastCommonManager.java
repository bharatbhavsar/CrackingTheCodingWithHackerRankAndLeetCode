/**
 * Given the pair of employee and immediate manager, find the most immediate manager between 2 given employee
 * to solve the conflict between them.
 */



package ibmCodingChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindLeastCommonManager {
	
	// arguments are passed using the text field below this editor
	  public static void main(String[] args) throws Exception{
		 
		  String input = "Sam->Pete,Pete->Nancy,Sam->Katie,Mary->Bob,Frank->Mary,Mary->Sam,Bob->John"; 
		  String[] relations = input.split(",");
		  Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    
		  for(String r : relations){
	      
			  String[] p = r.split("->");
			  if(map.containsKey(p[0])){
				  map.get(p[0]).add(p[1]);   
			  }else{
				  ArrayList<String> list = new ArrayList<String>();
				  list.add(p[1]);
				  map.put(p[0],list);
			  }
		  }
	    
		  for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
			  String key = entry.getKey();
			  ArrayList<String> value = entry.getValue();
		  }
		  String name1 = "Nancy";
		  String name2 = "Katie";
	    
		  ArrayList<String> name1M = new ArrayList<String>();
		  ArrayList<String> name2M = new ArrayList<String>();    
	    
		  for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
			  String key = entry.getKey();
			  ArrayList<String> value = entry.getValue();
	      
			  if(value.contains(name1) && value.contains(name2)){
				  System.out.println("Manager found  "+ key);
				  return;
			  }           
	  		} 
	    
		  rec(map, name1M, name1);
	      rec(map, name2M, name2);
	           
	      for(String m1 : name1M){    
	    	  for(String m2 : name2M){
	    		  if(m1.equals(m2)){
	    			  System.out.println("Manager Found + " + m1);
	    			  return;
	    		  }
	    	  }
	      }
	  }
	  
	  public static void rec(Map<String, ArrayList<String>> map, ArrayList<String> managerList, String name){
		  for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			  if(entry.getValue().contains(name)){
				  managerList.add(entry.getKey());
				  rec(map, managerList, entry.getKey());
				  break;
		      }   
		  }
	  } 
		    
}


