package ru.tsibrovskii.lesson1.Typedata;

public class Calculator {

    static double result;

    public void Add(double first, double second) {
        result = first + second;
    }

    public void Substruct(double first, double second) {
        result = first - second;
    }

    public void Div(double first, double second) {
        result = first / second;
    }

    public void Multiple(double first, double second) {
        result = first * second;
    }

}