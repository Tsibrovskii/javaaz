package ru.tsibrovskii.chess;

public class WhitePawn extends Figure {

    WhitePawn(Cell position) {
        super(position);
    }

    public Cell[] way(Cell dist) {
        if((dist.y - position.y) <= 1 && (dist.x - position.x) == 0) return new Cell[]{dist};

        throw new ImposibleMoveException("Impossible move.");
    }
}
