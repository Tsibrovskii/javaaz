package ru.tsibrovskii.chess;

/**
 * Класс, описывающий шахматную доску.
 */
public class Board {

    Figure[] figures;

    /**
     * Метод, проверящий, может ли фигура переместиться в заданное положение
     * @param source начальная клетка.
     * @param dist клетка назначения.
     * @return результат, может или не может фигура быть перемещена в нужное положение.
     */
    boolean move(Cell source, Cell dist) {

        boolean check = false;

        Figure figureToMove = null;

        // Проверка на наличие фигуры в клетке
        if (figures != null) {
            for (Figure figure : figures) {
                if (figure.position == source) {
                    check = true;
                    figureToMove = figure;
                }
            }
        }
        if (check == false) throw new FigureNotFoundException("Figure not found.");

        // Проверка на возможность передвижения фигуры в нужную позицию.
        Cell[] wayCells = figureToMove.way(dist);

        // Проверка на наличие препятствий (других фигур) на пути движения фигуры.
        for (Figure figure : figures) {
            for (Cell figureOccupied : wayCells) {
                if (figureOccupied.equals(figure.position)) throw new OccupiedWayException("Occupied position.");
            }
        }

        return check;
    }
}
