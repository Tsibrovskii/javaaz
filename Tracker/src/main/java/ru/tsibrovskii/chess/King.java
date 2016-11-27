package ru.tsibrovskii.chess;

public class King extends Figure {

    King(Cell position) {
        super(position);
    }

    public Cell[] way(Cell dist) {
        if(Math.max(Math.abs(dist.x - position.x), Math.abs(dist.y - position.y)) <= 1) return new Cell[]{dist};

        throw new ImposibleMoveException("Impossible move.");
    }
}
