package com.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

public class OraclePhoneInterview {

	
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> a = new ArrayList<String>();
		a.add("pune");
		a.add("mumbai");
		list.add(a);
		ArrayList<String> b = new ArrayList<String>();
		b.add("nashik");
		b.add("pune");
		list.add(b);
		ArrayList<String> c = new ArrayList<String>();
		c.add("mumbai");
		c.add("nagpur");
		list.add(c);
		ArrayList<String> d = new ArrayList<String>();
		d.add("thane");
		d.add("nashik");
		list.add(d);
		
		System.out.println(sortedRoutes2(list));
		
	}
	
	public static ArrayList<ArrayList<String>> sortedRoutes(ArrayList<ArrayList<String>> givenRoutes){
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		
		HashMap<String, String> myMap = new HashMap<String, String>();
		
		for(ArrayList<String> l: givenRoutes) {
			myMap.put(l.get(0), l.get(1));
		}
		
		res.add(givenRoutes.get(0));
		while(true) {
			if(myMap.containsKey(res.get(res.size()-1).get(1))) {
				ArrayList<String> a = new ArrayList<String>();
				a.add(res.get(res.size()-1).get(1));
				a.add(myMap.get(res.get(res.size()-1).get(1)));
				res.add(a);
			}else {
				break;
			}
		}
		while(true) {
			if(myMap.containsValue(res.get(0).get(0))) {
				ArrayList<String> a = new ArrayList<String>();
//				for (Entry<String, String> entry : myMap.entrySet()) {
//		            if (entry.getValue().equals(res.get(0).get(0))) {
//		                a.add(entry.getKey());
//		            }
//		        }
				a.add(myMap
	              .entrySet()
	              .stream()
	              .filter(entry -> Objects.equals(entry.getValue(), res.get(0).get(0)))
	              .map(Map.Entry::getKey)
	              .collect(Collectors.toSet()).iterator().next());
				
				
				a.add(res.get(0).get(0));
				res.add(0,a);
			}else {
				break;
			}
		}
		
		return res;
	}
	
	
	public static ArrayList<ArrayList<String>> sortedRoutes2(ArrayList<ArrayList<String>> givenRoutes){
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		
		HashMap<String, String> myMap = new HashMap<String, String>();
		
		for(ArrayList<String> l: givenRoutes) {
			myMap.put(l.get(0), l.get(1));
		}
		
		for(ArrayList<String> l: givenRoutes){
			if(!myMap.containsValue(l.get(0))) {
				ArrayList<String> a = new ArrayList<String>();
				a.add(l.get(0));
				a.add(l.get(1));
				res.add(a);
				break;
			}
		}
		
		while(myMap.containsKey(res.get(res.size()-1).get(1))) {
			ArrayList<String> a = new ArrayList<String>();
			a.add(res.get(res.size()-1).get(1));
			a.add(myMap.get(res.get(res.size()-1).get(1)));
			res.add(a);
		}
		
		return res;
		
	}
}
