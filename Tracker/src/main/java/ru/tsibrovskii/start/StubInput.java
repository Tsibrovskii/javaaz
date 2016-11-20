package ru.tsibrovskii.start;

/**
 * Класс для ввода данных, используемый в тестах StartUITest
 */
public class StubInput implements Input {

    private String[] answers;
    private int position = 0;

    /**
     * Конструктор класса
     * @param answers возможные "вводы" пользователя
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Метод, возвращающий следующий возможный ввод пользователя.
     * @param question вопрос, задаваемый пользователю.
     * @return возможный ввод пользователя.
     */
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * Метод
     * @param question вопрос, задаваемый пользователю.
     * @param range диапазон значений
     * @return <b>key</b> - выбор из меню - ключ (ввод пользователя)
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
            throw new MenuOutException("Out of menu range");
        }
    }
}
