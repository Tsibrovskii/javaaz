package ru.tsibrovskii.lesson1.ConditionOperator;

public class Point {
	public double x;
	public double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distanceTo(Point point) {
		// calculate distance between two points
		double distance = Math.sqrt(Math.pow((this.x - point.x), 2) + 
		                            Math.pow((this.y - point.y), 2));
		if (distance > 0)
			return distance;
		else
			return -1;
	}
}