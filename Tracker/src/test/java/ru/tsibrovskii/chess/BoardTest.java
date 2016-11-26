package ru.tsibrovskii.chess;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class BoardTest {

    @Test
    public void whenGiveFigureShouldReturnInBack() {

        Board board = new Board();
        board.fillBoardByNull();

        int x = 3;
        int y = 3;
        Cell cellSource = new Cell(x, y);

        Figure elephant = new Elephant(cellSource);

        board.fillBoard(elephant);

        Assert.assertThat(board.figures[x][y], is(elephant));

    }

    @Test (expected = FigureNotFoundException.class)
    public void whenGivePositionWithoutFigureShouldThrowException() {

        Board board = new Board();
        board.fillBoardByNull();

        int x1 = 4;
        int y1 = 4;
        Cell cellSource = new Cell(x1, y1);

        Figure elephant = new Elephant(cellSource);

        board.fillBoard(elephant);

        int x2 = 3;
        int y2 = 3;
        Cell cellDist = new Cell(x2, y2);

        board.move(cellDist, cellDist);

    }

    @Test (expected = ImposibleMoveException.class)
    public void whenGiveWrongDistShouldThrowException() {

        Board board = new Board();
        board.fillBoardByNull();

        int x1 = 4;
        int y1 = 4;
        Cell cellSource = new Cell(x1, y1);

        Figure elephant = new Elephant(cellSource);

        board.fillBoard(elephant);

        int x2 = 3;
        int y2 = 1;
        Cell cellDist = new Cell(x2, y2);

        board.move(cellSource, cellDist);

    }

    @Test (expected = OccupiedWayException.class)
    public void whenGiveWayShouldThrowException() {

        Board board = new Board();
        board.fillBoardByNull();

        int x1 = 4;
        int y1 = 4;
        Cell cellSource = new Cell(x1, y1);

        Figure elephant = new Elephant(cellSource);

        board.fillBoard(elephant);

        int x2 = 3;
        int y2 = 3;
        Cell cellOccupiedFigure = new Cell(x2, y2);

        Figure occupiedFigure = new Elephant(cellOccupiedFigure);

        board.fillBoard(occupiedFigure);

        int x3 = 1;
        int y3 = 1;
        Cell cellDist = new Cell(x3, y3);

        board.move(cellSource, cellDist);

    }

    @Test
    public void whenGiveFigureAndDistinationShouldMoveIt() {

        Board board = new Board();
        board.fillBoardByNull();

        int x1 = 7;
        int y1 = 7;
        Cell cellSource = new Cell(x1, y1);

        Figure elephant = new Elephant(cellSource);

        board.fillBoard(elephant);

        int x2 = 3;
        int y2 = 3;
        Cell cellDist = new Cell(x2, y2);

        board.move(cellSource, cellDist);

        Assert.assertThat(board.figures[x2][y2], is(elephant));
        Assert.assertTrue(board.figures[x1][y1] == null);
    }

}
