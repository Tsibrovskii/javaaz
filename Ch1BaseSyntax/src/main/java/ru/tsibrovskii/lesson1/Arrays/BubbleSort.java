package ru.tsibrovskii.lesson1.Arrays;

public class BubbleSort {

	public int[] sort(int[] values) {
		
		for(int i = 0; i < values.length - 1; i++) {
			
			for(int j = values.length - 1; j > i; j--) {		
			
				if (values[j] < values[j-1]) {	
				
					int buffer = values[j];
					values[j] = values[j-1];
					values[j-1] = buffer;
				}				
			}
		}
		
		return values;
	}
}
