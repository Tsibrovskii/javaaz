package ru.tsibrovskii.lesson1.ConditionOperator;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TriangleTest {
	
	Point tochka1 = new Point(2, 3);
	Point tochka2 = new Point(-2, 3);
	Point tochka3 = new Point(-2, 0);
	
	double dist1 = tochka1.distanceTo(tochka2);
	double dist2 = tochka1.distanceTo(tochka3);
	double dist3 = tochka2.distanceTo(tochka3);
	
	@Test
	public void whenGivePointsItShouldGiveDistance(){
				
		Assert.assertThat(dist1, is(4d));
		Assert.assertThat(dist2, is(5d));
		Assert.assertThat(dist3, is(3d));
	}
	
	@Test
	public void whenGivePointsItShouldGiveArea(){
		
		Triangle triangle = new Triangle(tochka1, tochka2, tochka3);
		
		double area = triangle.area();
		
		Assert.assertThat(area, is(6d));
	}
	
	@Test
	public void whenGivePointsItShouldGiveMaxLength(){
		
		MaxLength maxLength = new MaxLength();
		
		double max = maxLength.max(dist1, dist2, dist3);
		
		Assert.assertThat(max, is(5d));
	}
}
