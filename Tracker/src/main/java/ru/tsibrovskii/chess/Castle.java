package ru.tsibrovskii.chess;

public class Castle extends Figure {

    Castle(Cell position) {
        super(position);
    }

    Cell[] resArray;

    public Cell[] way(Cell dist) {
        if(dist.x == position.x || dist.y == position.y) {
            resArray = new Cell[Math.max(Math.abs(dist.x - position.x), Math.abs(dist.y - position.y))];
            int x = position.x;
            int y = position.y;

            for (int i = 0; i < Math.max(Math.abs(dist.x - position.x), Math.abs(dist.y - position.y)); i++) {
                if (dist.x - position.x == 0) y = y + ((dist.y - position.y)/Math.abs(dist.y - position.y));
                else x = x + ((dist.x - position.x)/Math.abs(dist.x - position.x));
                resArray[i] = new Cell(x, y);
            }
        } else {
            throw new ImposibleMoveException("Impossible move.");
        }
        return resArray;
    }
}
