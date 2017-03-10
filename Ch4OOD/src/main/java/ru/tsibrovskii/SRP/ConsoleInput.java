package ru.tsibrovskii.SRP;

import java.util.Scanner;

/**
 * Класс для работы с вводом от пользователя.
 */
public class ConsoleInput implements Input {

    /**
     * Метод считывания ввода пользователя.
     * @param question вопрос, задаваемый пользователю.
     * @return ввод пользователя.
     */
    public double ask(String question) {
        System.out.println(question);
        boolean exist = false;
        int i = -1;
        do {
            try {
                i = Integer.valueOf(new Scanner(System.in).nextLine());
                exist = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Вы должны ввести число.");
            }
        } while (!exist);
        return i;
    }

    /**
     * Метод считывания ввода пользователя.
     * @param question вопрос, задаваемый пользователю.
     * @param range диапазон возможных значений.
     * @return ввод пользователя, либо исключение.
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(new Scanner(System.in).nextLine());
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new OutOfRangesException("Out of menu range.");
        }
    }
}
