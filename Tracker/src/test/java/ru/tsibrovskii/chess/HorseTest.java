package ru.tsibrovskii.chess;

import org.junit.Assert;
import org.junit.Test;

public class HorseTest {

    @Test
    public void whenGiveDistShouldGiveBackArrayOfDisplacements() {

        int x = 4;
        int y = 4;
        Cell position = new Cell(x, y);
        Horse horse = new Horse(position);

        int x2 = 5;
        int y2 = 6;
        Cell dist = new Cell(x2, y2);

        Cell[] resArray = new Cell[1];
        resArray[0] = new Cell(x2, y2);

        Assert.assertArrayEquals(horse.way(dist), resArray);
    }

    @Test (expected = ImposibleMoveException.class)
    public void whenGiveDistShouldThrowException() {

        int x = 4;
        int y = 4;
        Cell position = new Cell(x, y);
        Horse horse = new Horse(position);

        int x2 = 5;
        int y2 = 5;
        Cell dist = new Cell(x2, y2);

        horse.way(dist);
    }
}
