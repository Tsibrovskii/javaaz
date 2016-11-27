package ru.tsibrovskii.chess;

import org.junit.Assert;
import org.junit.Test;

public class WhitePawnTest {

    @Test
    public void whenGiveDistShouldGiveBackArrayOfDisplacements() {

        int x = 2;
        int y = 2;
        Cell position = new Cell(x, y);
        WhitePawn whitePawn = new WhitePawn(position);

        int y2 = 3;
        Cell dist = new Cell(x, y2);

        Cell[] resArray = new Cell[1];
        resArray[0] = new Cell(x, y2);

        Assert.assertArrayEquals(whitePawn.way(dist), resArray);
    }

    @Test (expected = ImposibleMoveException.class)
    public void whenGiveDistShouldThrowException() {

        int x = 4;
        int y = 4;
        Cell position = new Cell(x, y);
        WhitePawn whitePawn = new WhitePawn(position);

        int y2 = 6;
        Cell dist = new Cell(x, y2);

        whitePawn.way(dist);
    }
}
