package ru.tsibrovskii.lesson1.Loops;

public class Square {
	
	double a, b, c, rez;
	
	float y;
	
	public Square(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public float calculate(int x) {

		rez = a * Math.pow(x, 2) + b * x + c; 
		
		y = (float) rez;
					
		return y;
		
	}
	
	public static void main(String[] args) {
		
		double a = Double.valueOf(args[0]);
		double b = Double.valueOf(args[1]);
		double c = Double.valueOf(args[2]);
		int x1 = Integer.valueOf(args[3]);
		int x2 = Integer.valueOf(args[4]);
		int step = Integer.valueOf(args[5]);
		
		Square calc = new Square(a, b, c);
		
		for (int i = x1; i <= x2; i = i + step) {
			
			System.out.println(calc.calculate(i));
			
		}
	}
}