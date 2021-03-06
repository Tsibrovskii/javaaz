package ru.tsibrovskii.lesson1.Typedata;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest {
	@Test
	public void whenAddShouldSummateIt() {
		final Calculator calc = new Calculator();
		calc.add(1, 1);
		final double result = calc.result;
		Assert.assertThat(result, is(2d));
	}
	
	@Test
	public void whenSubstructShouldSubstructIt() {
		final Calculator calc = new Calculator();
		calc.substruct(8, 1);
		final double result = calc.result;
		Assert.assertThat(result, is(7d));
	}
	
	@Test
	public void whenDivShouldDivideIt() {
		final Calculator calc = new Calculator();
		calc.div(18, 3);
		final double result = calc.result;
		Assert.assertThat(result, is(6d));
	}
	
	@Test
	public void whenMultipleShouldMultipleIt() {
		final Calculator calc = new Calculator();
		calc.multiple(2, 5);
		final double result = calc.result;
		Assert.assertThat(result, is(10d));
	}
}
