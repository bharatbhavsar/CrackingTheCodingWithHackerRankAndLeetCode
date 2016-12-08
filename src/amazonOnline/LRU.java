package amazonOnline;
import java.util.LinkedList;
import java.util.List;


public class LRU {
	
	int lruCountMiss(int lruSize, int[] inpArray, int inpSize){
		List<Integer> lruCache = new LinkedList<Integer>();
		int cacheMiss = 0;
		for(int i=0;i<inpSize;i++){
			if(lruCache.contains(inpArray[i])){
				int index = lruCache.indexOf(inpArray[i]);
				lruCache.remove(index);
				lruCache.add(inpArray[i]);
			}else{
				cacheMiss++;
				if(lruCache.size()<lruSize)
				lruCache.add(inpArray[i]);
				else{
					lruCache.remove(0);
					lruCache.add(inpArray[i]);
				}
			}
		}
		return cacheMiss;
	}
	
	public static void main(String[] args){
		LRU l = new LRU();
		int[] inputArray = {2,3,1,3,2,1,4,3,2};
		int cacheMiss = l.lruCountMiss(2, inputArray, 9);
		System.out.println("cacheMiss = " +cacheMiss);
	}
	
}
