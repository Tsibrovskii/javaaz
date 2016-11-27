package ru.tsibrovskii.chess;

import org.junit.Assert;
import org.junit.Test;

public class KingTest {

    @Test
    public void whenGiveDistShouldGiveBackArrayOfDisplacements() {

        int x = 2;
        int y = 2;
        Cell position = new Cell(x, y);
        King king = new King(position);

        int x2 = 3;
        int y2 = 3;
        Cell dist = new Cell(x2, y2);

        Cell[] resArray = new Cell[1];
        resArray[0] = new Cell(x2, y2);

        Assert.assertArrayEquals(king.way(dist), resArray);
    }

    @Test (expected = ImposibleMoveException.class)
    public void whenGiveDistShouldThrowException() {

        int x = 4;
        int y = 4;
        Cell position = new Cell(x, y);
        King king = new King(position);

        int x2 = 6;
        int y2 = 5;
        Cell dist = new Cell(x2, y2);

        king.way(dist);
    }
}
