package ru.tsibrovskii;

import org.junit.Test;
import ru.tsibrovskii.CollectionsFramework.ConvertList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс.
 */
public class ConvertListTest {

    /**
     * Тестовый метод, проверяющий корректность перевода двумерного массива в лист.
     */
    @Test
    public void whenGiveArrayShouldConvertIntoList() {

        ConvertList convertList = new ConvertList();
        int[][] array = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> resultList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        List<Integer> list = convertList.toList(array);

        assertThat(list, is(resultList));
    }

    /**
     * Тестовый метод, проверяющий корректность перевода листа в двумерный массив.
     */
    @Test
    public void whenGiveListShouldConvertIntoArray() {

        ConvertList convertList = new ConvertList();
        int[][] resultArray = new int[][]{{1,2,3},{4,5,6},{7,0,0}};
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        int[][] array = convertList.toArray(list, 3);

        assertThat(array, is(resultArray));
    }
}
