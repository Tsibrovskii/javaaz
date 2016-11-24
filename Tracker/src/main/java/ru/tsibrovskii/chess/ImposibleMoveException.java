package ru.tsibrovskii.chess;

public class ImposibleMoveException extends RuntimeException {

    ImposibleMoveException(String msg) {
        super(msg);
    }
}
