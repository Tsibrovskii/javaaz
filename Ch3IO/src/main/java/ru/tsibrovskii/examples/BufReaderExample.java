package ru.tsibrovskii.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Пример.
 */
public class BufReaderExample {

    /**
     * Главный метод.
     * @param args аргументы.
     * @throws IOException исключение.
     */
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите символы, 'q' - окончание ввода.");
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
