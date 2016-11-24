package ru.tsibrovskii.chess;

/**
 * Класс, описывающий ячейку шахматной доски.
 */
public class Cell {

    int x, y;

    /**
     * Конструктор по молчанию
     * @param x координата по горизонтали
     * @param y координата по вертикали
     */
    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cell other = (Cell) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
