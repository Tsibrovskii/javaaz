package ru.tsibrovskii.lesson1.ConditionOperator;

public class MaxLength {
	
	double maxLen;
	
	public double max(double dist1, double dist2, double dist3) {
		
		if (dist1 > dist2)
			maxLen = dist1;
		else
			maxLen = dist2;
		
		if (maxLen < dist3)
			maxLen = dist3;
		
		return maxLen;		
	}
}
