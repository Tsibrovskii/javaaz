package ru.tsibrovskii.lesson1.Arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BubbleSortTest {
	
	@Test
	public void whenGiveNotSortArrayItShouldReturnSortArray() {
		
		int[] values = new int[] {1, 3, 2, 8, -3, 16, 93, -4};
		int[] sortvalues = new int[] {-4, -3, 1, 2, 3, 8, 16, 93};
		
		BubbleSort bubble = new BubbleSort();
		int[] rezmassiv = bubble.sort(values);
		
		Assert.assertThat(rezmassiv, is(sortvalues));
	}
}