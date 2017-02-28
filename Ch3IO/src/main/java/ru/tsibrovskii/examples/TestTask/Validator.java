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
     * Метод, возвращающий директорию поиска файла.
     * @return директория поиска.
     */
    public String getDirectory() {
        return this.args[1];
    }

    /**
     * Метод, возвращающий имя искомого файла.
     * @return имя файла.
     */
    public String getFileName() {
        return this.args[3];
    }

    /**
     * Метод, возвращающий маску поиска.
     * @return маска поиска.
     */
    public String getMask() {
        return this.args[4];
    }

    /**
     * Метод, возвращающий имя файла с результатами.
     * @return имя файла результатов.
     */
    public String getLogFile() {
        return this.args[6];
    }

    /**
     * Метод проверки правильности ввода пользователя.
     * @return результат проверки.
     */
    public boolean checkArgs() {
        if (args.length != 7) {
            return false;
        }
        if (!"-d".equals(args[0])) {
            return false;
        }
        if (!"-n".equals(args[2])) {
            return false;
        }
        if (!"-m".equals(args[4]) && !"-f".equals(args[4])) {
            return false;
        }
        if (!"-o".equals(args[5])) {
            return false;
        }
        if (args[1] == null || args[3] == null || args[6] == null) {
            return false;
        }
        return true;
    }
}
