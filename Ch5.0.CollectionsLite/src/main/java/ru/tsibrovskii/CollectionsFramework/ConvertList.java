package ru.tsibrovskii.CollectionsFramework;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс конвертации двумерного массива в лист и обратно.
 */
public class ConvertList {

    /**
     * Метод преобразования двумерного массива в лист. Перебор по строкам.
     * @param array входной массив.
     * @return лист.
     */
    public List<Integer> toList (int[][] array) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }

    /**
     * Метод преобразования листа элементов в двумерный массив.
     * @param list лист элементов.
     * @param rows количество строк в конечном массиве.
     * @return двумерный массив.
     */
    public int[][] toArray (List<Integer> list, int rows) {

        int column = list.size() / rows;
        if(column * rows != list.size()) {
            column++;
        }
        int[][] array = new int[rows][column];

        int counter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if(counter < list.size()) {
                    array[i][j] = list.get(counter);
                } else {
                    array[i][j] = 0;
                }
                counter++;
            }
        }
        return array;
    }
}
