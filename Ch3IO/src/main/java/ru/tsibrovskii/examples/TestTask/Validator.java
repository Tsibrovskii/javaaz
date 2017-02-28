package ru.tsibrovskii.examples.TestTask;

/**
 * Класс проверки корректности ввода.
 */
public class Validator {

    private String[] args = new String[6];

    /**
     * Конструктор класса.
     * @param args аргументы.
     */
    public Validator(String[] args) {
        this.args = args;
    }

    /**
     * Метод проверки правильности ввода пользователя.
     * @return результат проверки.
     */
    public boolean checkArgs() {
        if (args.length != 7) {
            System.out.println("not 7 args");
            return false;
        }
        if (!"-d".equals(args[0])) {
            System.out.println("error in path");
            return false;
        }
        if (!"-n".equals(args[2])) {
            System.out.println("error in name of file");
            return false;
        }
        if (!"-m".equals(args[4]) && !"-f".equals(args[4])) {
            System.out.println("error in mask");
            return false;
        }
        if (!"-o".equals(args[5])) {
            System.out.println("error in log-file");
            return false;
        }
        if (args[1] == null || args[3] == null || args[6] == null) {
            return false;
        }
        return true;
    }
}
