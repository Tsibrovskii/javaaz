package ru.tsibrovskii.SRP;

import com.google.common.base.Joiner;

import java.util.Scanner;

/**
 * Класс калькулятора.
 */
public class InteractCalc {

    private final String LN = System.getProperty("line.separator");

    /**
     * Метод, выводящий на экран информацию о возможных действиях.
     */
    public void info() {

    }

    /**
     * Основной метод класса.
     * @param args аргументы.
     */
    public static void main(String[] args) {
        MenuCalc menu = new MenuCalc();
        menu.fillTheMenu();
        menu.showTheMenu();
    }
}
