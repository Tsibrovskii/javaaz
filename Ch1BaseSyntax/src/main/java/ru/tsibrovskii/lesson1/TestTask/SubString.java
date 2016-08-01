package ru.tsibrovskii.lesson1.TestTask;

public class SubString {
	
	public boolean contains(String origin, String sub) {
		
		int len1 = origin.length();
		int len2 = sub.length();
		boolean rezult = false;
		
		char[] originArray = new char[len1];
		char[] subArray = new char[len2];
		
		for (int i = 0; i < len1; i++) {
			originArray[i] = origin.charAt(i);
		}
		
		for (int i = 0; i < len2; i++) {
			subArray[i] = sub.charAt(i);
		}
			
		for (int i = 0; i < len1; i++) {
			if (originArray[i] == subArray[0]) {
				int k = i + 1;
				for (int j = 1; j < len2; j++) {
					if (originArray[k] == subArray[j]) {
						if (j == len2 - 1) {
							rezult = true;
						}
						k++;
					}
				}						
			}
		}
		
		return rezult;
	}
}