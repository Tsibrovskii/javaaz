package ru.tsibrovskii.chess;

import org.junit.Assert;
import org.junit.Test;

public class ElephantTest {

    @Test
    public void whenGiveDistShouldGiveBackArrayOfDisplacements() {

        int x = 8;
        int y = 4;
        Cell position = new Cell(x, y);
        Elephant elephant = new Elephant(position);

        int x2 = 4;
        int y2 = 8;
        Cell dist = new Cell(x2, y2);

        Cell[] resArray = new Cell[4];
        resArray[0] = new Cell(7, 5);
        resArray[1] = new Cell(6, 6);
        resArray[2] = new Cell(5, 7);
        resArray[3] = new Cell(4, 8);

        Assert.assertArrayEquals(elephant.way(dist), resArray);
    }

    @Test (expected = ImposibleMoveException.class)
    public void whenGiveDistShouldThrowException() {

        int x = 7;
        int y = 4;
        Cell position = new Cell(x, y);
        Elephant elephant = new Elephant(position);

        int x2 = 4;
        int y2 = 8;
        Cell dist = new Cell(x2, y2);

        elephant.way(dist);
    }
}
