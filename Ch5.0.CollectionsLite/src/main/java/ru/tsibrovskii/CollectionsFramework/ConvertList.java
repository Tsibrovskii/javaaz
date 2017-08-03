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
        for(int[] i : array) {
            for(int j : i) {
                list.add(j);
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

        int i = 0;
        int j = 0;
        for (int element : list) {
            array[i][j] = element;
            j++;
            if(j == column) {
                i++;
                j = 0;
            }
            if(i == rows) {
                break;
            }
        }
        return array;
    }

    /**
     * Метод преобразования листа массивов, содержащих Integer в лист Integer.
     * @param list лист массивов.
     * @return лист.
     */
    public List<Integer> convert (List<int[]> list) {

        List<Integer> convertedList = new ArrayList<>();

        for(int[] array : list) {
            for(int i : array) {
                convertedList.add(i);
            }
        }
        return convertedList;
    }
}
