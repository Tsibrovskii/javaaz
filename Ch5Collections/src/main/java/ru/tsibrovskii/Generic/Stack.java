package ru.tsibrovskii.Generic;

public class Stack extends SimpleList<Number> {

    Stack(int size) {
        super(size);
    }

    public static void main(String[] args) {
        Stack s = new Stack(3);
    }
}
