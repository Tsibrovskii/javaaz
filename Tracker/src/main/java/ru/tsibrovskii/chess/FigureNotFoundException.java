package ru.tsibrovskii.chess;

public class FigureNotFoundException extends NullPointerException {

    FigureNotFoundException(String msg) {
        super(msg);
    }
}
