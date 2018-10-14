package com.amazonOnline;

public class Point implements Comparable{
	int x;
	int y;
	float distanceFromOrigin;
	Point(){
		x = 0;
		y = 0;
		distanceFromOrigin = (float) 0.0;
	}
	Point(int x, int y){
		this.x = x;
		this.y = y;
		calculateDistanceFromOrigin();
	}
	public void calculateDistanceFromOrigin(){
		this.distanceFromOrigin = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public void calculateDistanceFromPoint(Point p){
		this.distanceFromOrigin = (float) Math.sqrt(Math.pow((x - p.x), 2) + Math.pow((y - p.y), 2));
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		Point point2 = (Point)arg0;
		if(this.distanceFromOrigin < point2.distanceFromOrigin)
			return -1;
		else if(this.distanceFromOrigin > point2.distanceFromOrigin)
			return 1;
		else
			return 0;
	}
	@Override
	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append("(" + this.x + "," + this.y + ")");
		return result.toString();
	}
	
}
