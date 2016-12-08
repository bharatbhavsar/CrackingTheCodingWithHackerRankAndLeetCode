package amazonOnline;

import java.util.Collections;
import java.util.PriorityQueue;


public class KPointsClosestToOrigin {

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
		System.out.print("\nK nearest Points:\n");
		while(!q.isEmpty()){
			System.out.print(q.peek().toString() + "\n");
			q.poll();
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		System.out.println("K points closest to origin");
		Point[] points = new Point[9];
		Point p = new Point(1, 1);
		points[0] = p;
		p = new Point(1, 3);
		points[1] = p;
		p = new Point(-1, 1);
		points[2] = p;
		p = new Point(-1, 3);
		points[3] = p;
		p = new Point(1, -1);
		points[4] = p;
		p = new Point(3, -1);
		points[5] = p;
		p = new Point(-1, -1);
		points[6] = p;
		p = new Point(-1, 3);
		points[7] = p;
		p = new Point(2, 2);
		points[8] = p;
		
		
		select_3(points, 0, 7, 4);
		
		
	}
}
