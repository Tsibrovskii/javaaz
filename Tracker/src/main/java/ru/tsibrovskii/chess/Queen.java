package ru.tsibrovskii.chess;



public class Queen extends Figure {

    Queen(Cell positon) {
        super(positon);
    }

    Cell[] resArray;

    public Cell[] way(Cell dist) {
        if(Math.abs(dist.x - position.x) == Math.abs(dist.y - position.y) || dist.x == position.x || dist.y == position.y) {
            resArray = new Cell[Math.max(Math.abs(dist.x - position.x), Math.abs(dist.y - position.y))];
            int x = position.x;
            int y = position.y;

            for (int i = 0; i < Math.max(Math.abs(dist.x - position.x), Math.abs(dist.y - position.y)); i++) {
                if(dist.x - position.x != 0) x = x + ((dist.x - position.x)/Math.abs(dist.x - position.x));
                if(dist.y - position.y != 0) y = y + ((dist.y - position.y)/Math.abs(dist.y - position.y));
                resArray[i] = new Cell(x, y);
            }
        } else {
            throw new ImposibleMoveException("Impossible move.");
        }
        return resArray;
    }
}
