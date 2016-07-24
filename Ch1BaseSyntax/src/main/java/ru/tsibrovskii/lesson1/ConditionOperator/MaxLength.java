package ru.tsibrovskii.lesson1.ConditionOperator;

public class MaxLength {
	
	double max;
	
	public double max(double dist1, double dist2, double dist3) {
		
		if (dist1 > dist2)
			max = dist1;
		else
			max = dist2;
		
		if (max < dist3)
			max = dist3;
		
		return max;		
	}
}
