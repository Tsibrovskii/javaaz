package ru.tsibrovskii.lesson1.Arrays;

public class DuplicateString {
	
	public String[] duplicateDelete(String[] values) {
		
		int len = values.length;
		int numberofnum = 0;
		
		for(int i = 0; i < len; i++) {
			if (values[i] != null) {
				for(int j = i + 1; j < len; j++) {
					if (values[i] == values[j]) {
						values[j] = null;
						numberofnum++;
					}
				}
			} 
		}
		
		int k = 0;
		String[] withoutduplicate = new String[len - numberofnum];
		
		for(int i = 0; i < len; i++) {
			if (values[i] != null) {				
				withoutduplicate[k] = values[i];		
				k++;				
			}
		}
		
		return withoutduplicate;
	}
}