package ru.tsibrovskii.chess;

public class Horse extends Figure {

    Horse(Cell position) {
        super(position);
    }

    public Cell[] way(Cell dist) {

        if((dist.x == position.x + 1 || dist.x == position.x - 1) && (dist.y == position.y + 2 || dist.y == position.y - 2))
            return new Cell[]{dist};

        if((dist.x == position.x + 2 || dist.x == position.x - 2) && (dist.y == position.y + 1 || dist.y == position.y - 1))
            return new Cell[]{dist};

        throw new ImposibleMoveException("Impossible move.");

    }
}
