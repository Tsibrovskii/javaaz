package ru.tsibrovskii.chess;

public class Elephant extends Figure {

    Elephant(Cell position) {
        super(position);
    }

    Cell[] resArray;

    public Cell[] way(Cell dist) {
        if(Math.abs(dist.x - position.x) == Math.abs(dist.y - position.y)) {
            resArray = new Cell[Math.abs(dist.x - position.x)];
            int x = position.x;
            int y = position.y;

            for (int i = 0; i < Math.abs(dist.x - position.x); i++) {
                x = x + ((dist.x - position.x)/Math.abs(dist.x - position.x));
                y = y + ((dist.y - position.y)/Math.abs(dist.y - position.y));
                resArray[i] = new Cell(x, y);
            }
        } else {
            throw new ImposibleMoveException("Impossible move.");
        }
        return resArray;
    }
}
