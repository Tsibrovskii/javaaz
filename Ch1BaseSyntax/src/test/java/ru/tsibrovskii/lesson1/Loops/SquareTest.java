package ru.tsibrovskii.lesson1.Loops;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquareTest {
	
	@Test
	public void whenGiveParametresShouldGiveValueOfEquation() {
		
		Square equation = new Square(3, 1, 4);
		
		float rez = equation.calculate(10);
		
		Assert.assertThat(rez, is(314f));
	}
}