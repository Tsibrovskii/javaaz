package ru.tsibrovskii.lesson1.Arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RotateArrayTest {
	
	@Test
	public void whenGiveArrayShouldReturnRotatedArray() {
		
		int[][] basicarray = new int[][] {{1, 2},
										  {3, 4},
										  {5, 6},
										  {7, 8}};
		int[][] newarray = new int[][] {{2, 4, 6, 8},
										{1, 3, 5, 7}};
		
		RotateArray rotation = new RotateArray();
		
		int[][] rotatedarray = rotation.rotate(basicarray);
		
		Assert.assertThat(rotatedarray, is(newarray));
	}
}