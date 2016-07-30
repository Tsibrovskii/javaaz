package ru.tsibrovskii.lesson1.Arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DuplicateStringTest {
	
	@Test
	public void whenTakeArrayOfStringsShouldDeleteDuplicateStrings() {
		
		String[] values = new String[] {"One", "Two", "One", "Three", "Four", "Five", "Two"};
		String[] withoutduplicate = new String[] {"One", "Two", "Three", "Four", "Five"};
		
		DuplicateString duplicate = new DuplicateString();
		
		String[] rezvalues = duplicate.duplicateDelete(values);
		
		Assert.assertThat(rezvalues, is(withoutduplicate));

	}
}