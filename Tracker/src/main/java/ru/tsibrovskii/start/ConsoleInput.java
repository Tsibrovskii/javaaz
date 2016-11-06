package ru.tsibrovskii.start;

import java.util.*;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод, возвращающий ввод пользователя.
     * @param question вопрос, задаваемый пользователю.
     * @return ввод пользователя.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Метод, возвращающий выбор пользователя, и,
     * проверящий ввод на корректность.
     * @param question вопрос, задаваемый пользователю.
     * @param range диапазон значений
     * @return ввод пользователя или исключение.
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
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
            throw new MenuOutException("Out of menu range.");
        }
    }
}
