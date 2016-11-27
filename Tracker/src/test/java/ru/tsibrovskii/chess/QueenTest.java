package ru.tsibrovskii.chess;

import org.junit.Assert;
import org.junit.Test;

public class QueenTest {

    @Test
    public void whenGiveDistShouldGiveBackArrayOfDisplacements() {

        int x = 2;
        int y = 2;
        Cell position = new Cell(x, y);
        Queen queen = new Queen(position);

        int x1 = 3;
        int y1 = 3;
        int x2 = 4;
        int y2 = 4;
        Cell dist = new Cell(x2, y2);

        Cell[] resArray = new Cell[2];
        resArray[0] = new Cell(x1, y1);
        resArray[1] = new Cell(x2, y2);

        Assert.assertArrayEquals(queen.way(dist), resArray);
    }

    @Test (expected = ImposibleMoveException.class)
    public void whenGiveDistShouldThrowException() {

        int x = 4;
        int y = 4;
        Cell position = new Cell(x, y);
        Queen queen = new Queen(position);

        int x2 = 6;
        int y2 = 5;
        Cell dist = new Cell(x2, y2);

        queen.way(dist);
    }
}
