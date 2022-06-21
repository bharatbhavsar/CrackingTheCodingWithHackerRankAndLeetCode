/*
 * 
 *
 * 

Problem 1:

    a     |     a
   / \    |    / \
  b   c   |   c   b
 / \      |      / \
d   e     |     e   d    return true


 
    a     |     a
   / \    |    / \
  b   c   |   c   b
 / \      |      / \
d   e     |     e   x    return false (value doesn't match for last node)
  

    a     |     a
   / \    |    / \
  b   c   |   c   b
 / \      |    \   \
d   e     |     e   d    return false
 
class TreeNode {
  TreeNode left;
  TreeNode right;
  String value;
}
  
// Implement the following
boolean isMirror(TreeNode node1, TreeNode node2){




//* second question
public class RetainBestCache<K, V extends Rankable> {
  // Add any fields you need here
  int LowestCacheRank = 9999;
  int CacheCapacity = 0;
  /**
   * Constructor with a data source (assumed to be slow) and a cache size
   * @param ds the persistent layer of the the cache
   * @param capacity the number of entries that the cache can hold
   
  public RetainBestCache(DataSource<K, V> ds, int capacity) {
    // Implementation here
    HashMap<K, V> myCache = new HashMap<K, V>();
    CacheCapacity = capacity;

  }


  // create internal ds
  // set its capacity
 
  /**
   * Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,
   * retrieves it from the data source and, if possible, cache it. If the cache is full, attempt
   to cache the returned data,
   * evicting the V with lowest rank among the ones that it has available
   * If there is a tie, the cache may choose any V with lowest rank to evict.
   * @param key the key of the cache entry being queried
   * @return the Rankable value of the cache entry
   
  public V get(K key) {
    // Implementation here

    //check in internal ds

    //if not found check in hd DataSource
    
    //update internal ds   
  }

  public void updateInternalCache(){
    
  }


}
 
/*
 * For reference, here are the Rankable and DataSource interfaces.
 * You do not need to implement them, and should not make assumptions
 * about their implementations.
 
 
public interface Rankable {
  /**
   * Returns the Rank of this object, using some algorithm and potentially
   * the internal state of the Rankable.
   
  long getRank();
}
 
public interface DataSource<K, V extends Rankable> {
  V get (K key);
}
 * 
 * 
 */

package com.LinkedIn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class LinkedInInterview {
	
	public static void main(String[] args) {
		
	}
	
	boolean isMirror(TreeNode node1, TreeNode node2) {
		if(node1 != null && node2 == null)
			return false;
		if(node2 != null && node1 == null)
			return false;
		if(node1 == null && node2 == null)
			return true;
		if(node1.value != node2.value)
			return false;
		
		return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left); 
	}

}

class TreeNode {
	TreeNode left;
	TreeNode right;
	String value;
}

class DataSource<K, V extends Rankable> {
	V get(K key) {
		return (V)new Object();
	}
	
	int getRank(K key) {
		return 1;
	}
}

class RetainBestCache<K, V extends Rankable>{
	
	private Map<K, V> cache;
	private TreeMap<Integer, Set<K>> rank;
	private DataSource<K, V> dataSource;
	private int capacity;
	
	public RetainBestCache(DataSource<K, V> ds, int capacity) {
		this.dataSource = ds;
		this.capacity = capacity;
		this.cache = new HashMap<K, V>();
		this.rank = new TreeMap<Integer, Set<K>>();
	}
	
	public V get(K key) {
		V res = null;
		if(cache.containsKey(key)) {
			res = cache.get(key);
		} else {
			res = dataSource.get(key);
			int curRank = dataSource.getRank(key);
			
			cache.put(key, res);
			if(!rank.containsKey(curRank)) {
				rank.put(curRank, new HashSet<K>());	
			}
			
			rank.get(curRank).add(key);
			
			if(cache.size() > capacity) {
				removeLowestRank();
			}
			
		}
		
		return res;
	}	
	
	public void removeLowestRank() {
		Entry<Integer, Set<K>> firstEntry = rank.firstEntry();
		int firstKey = firstEntry.getKey();
		Set<K> firstSet = firstEntry.getValue();
		
		K toRemove = firstSet.iterator().next();
		
		// Remove from rank TreeMap
		firstSet.remove(toRemove);
		if (firstSet.isEmpty()) {
			rank.remove(firstKey);
		}
		
		// Remove from Cache Map
		cache.remove(toRemove);
	}
	
}


