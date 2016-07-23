package ru.tsibrovskii.lesson1.ConditionOperator;

public class Triangle {
	
	public Point a;
	public Point b;
	public Point c;
	
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double area() {
		//calculate the triangle area
		double area = 0.5*((a.x - c.x)*(b.y - c.y) - (b.x - c.x)*(a.y - c.y));
		if (area > 0)
			return area;
		else
			return -1;
	}
}