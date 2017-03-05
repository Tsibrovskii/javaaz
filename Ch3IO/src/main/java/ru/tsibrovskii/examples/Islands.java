package ru.tsibrovskii.examples;

/**
 * Класс определения наибольшей площади острова.
 */
public class Islands {

    private int[][] arr;
    private int max;
    private int area;

    /**
     * Метод, возвращающий максимальную площадь острова.
     * @param arr массив островов.
     * @return площадь.
     */
    public int maxArea(int[][] arr) {
        this.arr = arr;
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < this.arr[0].length; j++) {
                if (this.arr[i][j] == 1) {
                    this.area = 1;
                    this.arr[i][j] = 2;
                    if (i < this.arr.length - 1 && this.arr[i + 1][j] == 1) {
                        nextArea(i + 1, j, this.area);
                    }
                    if (i > 0 && this.arr[i - 1][j] == 1) {
                        nextArea(i - 1, j, this.area);
                    }
                    if (j < this.arr[0].length - 1 && this.arr[i][j + 1] == 1) {
                        nextArea(i, j + 1, this.area);
                    }
                    if (j > 0 && this.arr[i][j - 1] == 1) {
                        nextArea(i, j - 1, this.area);
                    }

                }
                if (this.area > max) {
                    max = this.area;
                }
            }
        }
        return max;
    }

    /**
     * Метод, определяющий площадь отдельного острова.
     * @param i первая входящая координата.
     * @param j вторая входящая координата.
     * @param area площадь.
     */
    public void nextArea(int i, int j, int area) {
        this.area = area;
        this.area++;
        this.arr[i][j] = 2;
        if (i < this.arr.length - 1 && this.arr[i + 1][j] == 1) {
            nextArea(i + 1, j, this.area);
        }
        if (i > 0 && this.arr[i - 1][j] == 1) {
            nextArea(i - 1, j, this.area);
        }
        if (j < this.arr[0].length - 1 && this.arr[i][j + 1] == 1) {
            nextArea(i, j + 1, this.area);
        }
        if (j > 0 && this.arr[i][j - 1] == 1) {
            nextArea(i, j - 1, this.area);
        }
    }
}
