package ru.tsibrovskii.chess;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {

    @Test (expected = FigureNotFoundException.class)
    public void whenGivePositionWithoutFigureShouldThrowException() {

        Board board = new Board();

        int x = 3;
        int y = 3;
        int x1 = 4;
        int y1 = 4;

        Cell cell = new Cell(x, y);
        Cell cellSource = new Cell(x1, y1);
        board.figures = new Figure[1];
        board.figures[0] = new Elephant(cell);

        board.move(cellSource, cell);

    }

    @Test (expected = ImposibleMoveException.class)
    public void whenGiveWrongDistShouldThrowException() {

        Board board = new Board();

        int x = 3;
        int y = 3;
        int x1 = 4;
        int y1 = 5;

        Cell cell = new Cell(x, y);
        Cell cellSource = new Cell(x1, y1);
        board.figures = new Figure[1];
        board.figures[0] = new Elephant(cell);

        board.move(cell, cellSource);

    }

    @Test (expected = OccupiedWayException.class)
    public void whenGiveWayShouldThrowException() {

        Board board = new Board();

        int x = 3;
        int y = 3;
        int x1 = 5;
        int y1 = 5;
        int x2 = 4;
        int y2 = 4;

        Cell cell = new Cell(x, y);
        Cell cellSource = new Cell(x1, y1);
        Cell cellOccupied = new Cell(x2, y2);
        board.figures = new Figure[2];
        board.figures[0] = new Elephant(cell);
        board.figures[1] = new Elephant(cellOccupied);

        board.move(cell, cellSource);

    }
}
