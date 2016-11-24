package ru.tsibrovskii.chess;

/**
 * Абстрактный класс для любой шахматной фигуры.
 */
public abstract class Figure {

    final Cell position;

    /**
     * Конструктор по умолчанию
     * @param position позиция
     */
    Figure(Cell position) {
        this.position = position;
    }

    /**
     * Метод, предназначенный для передвижения фигуры.
     * @param dist клетка назначения.
     * @return массив пройденных ячеек, либо исключение.
     */
    abstract Cell[] way(Cell dist);
}
