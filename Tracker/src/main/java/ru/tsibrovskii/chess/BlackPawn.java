package ru.tsibrovskii.chess;

public class BlackPawn extends Figure {

    BlackPawn(Cell position) {
        super(position);
    }

    public Cell[] way(Cell dist) {
        if((position.y - dist.y) <= 1 && (dist.x - position.x) == 0) return new Cell[]{dist};

        throw new ImposibleMoveException("Impossible move.");
    }
}
