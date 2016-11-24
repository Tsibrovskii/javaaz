package ru.tsibrovskii.chess;

public class OccupiedWayException extends RuntimeException {

    OccupiedWayException(String msg) {
        super(msg);
    }
}
