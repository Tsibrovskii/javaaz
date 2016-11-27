package ru.tsibrovskii.chess;

import org.junit.Assert;
import org.junit.Test;

public class CastleTest {

    @Test
    public void whenGiveDistShouldGiveBackArrayOfDisplacements() {

        int x = 2;
        int y = 2;
        Cell position = new Cell(x, y);
        Castle castle = new Castle(position);

        int x1 = 3;
        int x2 = 4;
        Cell dist = new Cell(x2, y);

        Cell[] resArray = new Cell[2];
        resArray[0] = new Cell(x1, y);
        resArray[1] = new Cell(x2, y);

        Assert.assertArrayEquals(castle.way(dist), resArray);
    }

    @Test (expected = ImposibleMoveException.class)
    public void whenGiveDistShouldThrowException() {

        int x = 4;
        int y = 4;
        Cell position = new Cell(x, y);
        Castle castle = new Castle(position);

        int x2 = 5;
        int y2 = 5;
        Cell dist = new Cell(x2, y2);

        castle.way(dist);
    }
}
