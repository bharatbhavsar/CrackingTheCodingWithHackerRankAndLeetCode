package com.amazonOnline;

public class KSmallestElements {
/*public static<T extends Comparable<? super T>> void select_2(T[] arr, int p, int r, int k)
	{
		// Take 2
		PriorityQueue<T> q = new PriorityQueue<T>();
		for(T i:arr)
		{
			q.offer(i);
		}
		T val=null;
		for(int i=1;i<=k;i++)
		{
			val=q.poll();
		}
		System.out.print("\nTake 2:\n");
		System.out.print("Output : " +  val);
	}
	public static<T extends Comparable<? super T>> void select_3(T[] arr, int p, int r, int k)
	{
		// Take 3
		PriorityQueue<T> q = new PriorityQueue<>(r-p+1, Collections.reverseOrder());
		for(int i=p;i<=p+k-1;i++)
		{		
			q.offer(arr[i]);
		}
		for(int i=p+k;i<=r;i++)
		{
			int cmp= arr[i].compareTo(q.peek());
			if(cmp<0)
			{
				q.poll();
				q.offer(arr[i]);
			}
			
		}
		System.out.print("\nTake 3:\n");
		System.out.print("Output : " +  q.peek());
	}
 * */
}
