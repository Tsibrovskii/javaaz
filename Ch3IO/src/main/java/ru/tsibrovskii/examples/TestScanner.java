package ru.tsibrovskii.examples;

import java.util.Scanner;

/**
 * Тестовый класс.
 */
public class TestScanner {

    /**
     * Главный метод.
     * @param args аргументы.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in;
        String in1;
        String in2;
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                in = sc.nextInt();
                System.out.println(in * 2);
            } else {
                System.out.println("Вы ввели нецелое число.");
            }
        }
        /*in1 = sc.nextLine();
        in2 = sc.nextLine();
        System.out.println(String.format("%s %s", in1, in2));

        String s1 = "GoogleChrome";
        String s2 = "GoogleChrome";
        System.out.println(s1.toUpperCase());
        System.out.println(s1.toLowerCase());
        System.out.println(s1.replace('o','a'));
        System.out.println(s1.charAt(0));
        System.out.println(s1.length());
        System.out.println(s1.indexOf('g'));
        System.out.println(s1.isEmpty());
        System.out.println(s1.equals(s2));*/
    }
}
