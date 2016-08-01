package ru.tsibrovskii.lesson1.TestTask;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SubStringTest {
	
	@Test
	public void whenGiveTwoStringsShouldGiveResultOfContains() {
		
		String origin = "Alphphabetpha";
		String sub = "pha";		
			
		SubString checking = new SubString();
		
		boolean rezult = checking.contains(origin, sub);

		Assert.assertThat(rezult, is(true));
	}
}