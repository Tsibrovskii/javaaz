package ru.tsibrovskii.lesson1.ConditionOperator;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TriangleTest {
	
	Point tochka1 = new Point(2, 3);
	Point tochka2 = new Point(-2, 3);
	Point tochka3 = new Point(-2, 0);
	
	@Test
	public void whenGivePointsItShouldGiveDistance(){
					
		double dist1 = tochka1.distanceTo(tochka2);
		double dist2 = tochka1.distanceTo(tochka3);
		double dist3 = tochka2.distanceTo(tochka3);
		
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
}