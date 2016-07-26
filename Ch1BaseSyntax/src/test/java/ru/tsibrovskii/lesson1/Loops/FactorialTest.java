package ru.tsibrovskii.lesson1.Loops;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactorialTest {
	
	@Test
	public void whenTakeNumberShouldGiveFactorial() {
		
		Factorial factorial = new Factorial(4);
		
		int rez = factorial.fact();
		
		Assert.assertThat(rez, is(24));
	}
}