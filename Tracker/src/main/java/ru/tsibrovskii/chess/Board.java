package ru.tsibrovskii.chess;

/**
 * Класс, описывающий шахматную доску.
 */
public class Board {

    Figure[][] figures = new Figure[8][8];

    /**
     * Метод заполнения доски пустыми клетками.
     */
    public void fillBoardbyNull() {
        for (int i = 0; i < figures.length; i++) {
            for (int j = 0; j < figures[i].length; j++) {
                figures[i][j] = null;
            }
        }
    }

    /**
     * Метод заполнения доски фигурами.
     * @param figure фигура(вместе с позицией), добавляемая на доску.
     */
    public void fillBoard(Figure figure) {
        figures[figure.position.x][figure.position.y] = figure;
    }

    /**
     * Метод, проверящий, может ли фигура переместиться в заданное положение
     * @param source начальная клетка.
     * @param dist клетка назначения.
     * @return результат, может или не может фигура быть перемещена в нужное положение.
     */
    boolean move(Cell source, Cell dist) {

        boolean check = false;

        // Проверка на наличие фигуры в клетке.
        if (figures[source.x][source.y] != null) check = true;

        // Выдать предупреждение, если клетка пустая.
        if (check == false) throw new FigureNotFoundException("Figure not found.");

        // Проверка на возможность передвижения фигуры в нужную позицию.
        Cell[] wayCells = figures[source.x][source.y].way(dist);

        // Проверка на наличие препятствий (других фигур) на пути движения фигуры.
        for (Cell figureOccupied : wayCells) {
            if (figures[figureOccupied.x][figureOccupied.y] != null)
                throw new OccupiedWayException("Occupied position.");
        }

        // Перемещаем фигуру, а старое место делаем null.
        figures[dist.x][dist.y] = figures[source.x][source.y];
        figures[source.x][source.y] = null;

        return check;
    }
}
