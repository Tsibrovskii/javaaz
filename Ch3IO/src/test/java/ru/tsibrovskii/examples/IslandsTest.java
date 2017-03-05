package ru.tsibrovskii.examples;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Тестовый класс.
 */
public class IslandsTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGiveArrayOfIslandsShouldReturnMaxArea() {

        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = 0;
            }
        }

        //Буква Е
        arr[1][1] = 1;
        arr[1][2] = 1;
        arr[2][1] = 1;
        arr[3][1] = 1;
        arr[3][2] = 1;
        arr[4][1] = 1;
        arr[5][1] = 1;
        arr[5][2] = 1;

        //Буква Н.
        arr[1][5] = 1;
        arr[2][5] = 1;
        arr[3][5] = 1;
        arr[4][5] = 1;
        arr[5][5] = 1;
        arr[3][6] = 1;
        arr[1][7] = 1;
        arr[2][7] = 1;
        arr[3][7] = 1;
        arr[4][7] = 1;
        arr[5][7] = 1;

        //Точки.
        arr[0][9] = 1;
        arr[9][9] = 1;

        //Буква О.
        arr[7][1] = 1;
        arr[8][1] = 1;
        arr[9][1] = 1;
        arr[7][2] = 1;
        arr[9][2] = 1;
        arr[7][3] = 1;
        arr[8][3] = 1;
        arr[9][3] = 1;

        //Буква Т.
        arr[7][5] = 1;
        arr[7][7] = 1;
        arr[7][6] = 1;
        arr[8][6] = 1;
        arr[9][6] = 1;

        int result = 11;
        int max = new Islands().maxArea(arr);

        Assert.assertThat(max, is(result));
    }
}