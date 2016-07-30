package ru.tsibrovskii.lesson1.Arrays;

public class RotateArray {
	
	public int[][] rotate(int[][] values) {
		
		int y = values.length;
		int x = values[0].length;
		int[][] rotatedarray = new int[x][y];
		
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				
				rotatedarray[x - 1 - j][i] = values[i][j];
				
			}
		}
		
		return rotatedarray;
		
	}
}