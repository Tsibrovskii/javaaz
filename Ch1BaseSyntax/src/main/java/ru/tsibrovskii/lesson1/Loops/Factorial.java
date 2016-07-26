package ru.tsibrovskii.lesson1.Loops;

public class Factorial {
	
	int x;
	
	public Factorial(int x) {
		this.x = x;
	}
	
	public int fact() {
		
		int rez = 1;
		
		for (int i = 1; i <= x; i++) {
			rez *= i;
		}
		
		return rez;
	}
}