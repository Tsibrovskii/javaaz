package ru.tsibrovskii.chess;

import static java.lang.StrictMath.abs;

public class Elephant extends Figure {

    Elephant(Cell position) {
        super(position);
    }

    Cell[] resArray;

    public Cell[] way(Cell dist) {
        if(abs(dist.x - position.x) == abs(dist.y - position.y)) {
            resArray = new Cell[abs(dist.x - position.x)];
            int x = position.x;
            int y = position.y;

            for (int i = 0; i < abs(dist.x - position.x); i++) {
                if (dist.x > position.x) {
                    x++;
                } else {
                    x--;
                }
                if (dist.y > position.y) {
                    y++;
                } else {
                    y--;
                }
                resArray[i] = new Cell(x, y);
            }
        } else {
            throw new ImposibleMoveException("Impossible move.");
        }
        return resArray;
    }
}
