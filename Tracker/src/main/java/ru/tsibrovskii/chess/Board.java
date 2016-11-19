package ru.tsibrovskii.chess;

public class Board {

    Figure[][] figures = new Figure[8][8];

    public void fillBoard() {

        for (int i = 0; i <= figures[1].length; i++) {
            figures[i][1] = new Pawn();
            figures[i][6] = new Pawn();
        }


    }
}
