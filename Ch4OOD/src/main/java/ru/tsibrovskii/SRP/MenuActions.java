package ru.tsibrovskii.SRP;

/**
 * Класс действий для приложения "Калькулятор".
 */
public class MenuActions {

    private double result;
    private int mainKey;
    private ActionOfCalc[] actionOfCalc;
    private int position = 0;
    private final Input input;

    /**
     * Конструктор класса.
     * @param input ввод пользователя.
     * @param size размер массива.
     */
    public MenuActions(Input input, int size) {
        this.input = input;
        this.actionOfCalc = new ActionOfCalc[size];
    }

    /**
     * Метод заполения массива действий калькулятора.
     */
    public void fillActions() {
        this.actionOfCalc[position++] = this.new SumOfNumbers();
        this.actionOfCalc[position++] = this.new SubtractionOfNumbers();
        this.actionOfCalc[position++] = this.new MultiplicationOfNumbers();
        this.actionOfCalc[position++] = this.new DivisionOfNumbers();
        this.actionOfCalc[position++] = this.new RepeatAction();
        this.actionOfCalc[position++] = this.new UseResult();
        this.actionOfCalc[position++] = this.new SinusOfNumber();
    }

    /**
     * Метод, возвращающий массив действий.
     * @return массив действий.
     */
    public ActionOfCalc[] getActionOfCalc() {
        return this.actionOfCalc;
    }

    /**
     * Метод для вызова выбранного действия.
     * @param key ключ выбранного действия.
     */
    public void selectAction(int key) {
        result = this.actionOfCalc[key - 1].operation(this.input);
        this.mainKey = this.actionOfCalc[key - 1].setKey();
    }

    /**
     * Метод печати результата операции на экран.
     */
    public void printResult() {
        System.out.println(String.format("%s %s", "Результат операции: ",this.result));
    }

    /**
     * Метод вывода меню приложения на экран.
     */
    public void show() {
        for (ActionOfCalc actionOfCalc : this.actionOfCalc) {
            if (actionOfCalc != null) {
                this.showAction(actionOfCalc);
            }
        }
    }

    /**
     * Метод, печатающий на экран информацию о выбранном действии.
     * @param actionOfCalc выбранное действие из меню.
     */
    public void showAction(ActionOfCalc actionOfCalc) {
        System.out.println(actionOfCalc.information());
    }

    /**
     * Класс сложения чисел.
     */
    public class SumOfNumbers implements ActionOfCalc {

        /**
         * Метод, возвращающий информацию о действии.
         * @return информация.
         */
        public String information() {
            return String.format("%s. %s", this.key(), "Сложение.");
        }

        /**
         * Метод, возвращающий ключ для сложения чисел.
         * @return ключ.
         */
        public int key() {
            return 1;
        }

        /**
         * Метод, возвращающий ключ последнего выполненного действия.
         * @return ключ.
         */
        public int setKey() {
            return this.key();
        }

        /**
         * Метод, складывающий 2 числа.
         * @param input ввод пользователя.
         * @return сумма.
         */
        public double operation(Input input) {
            double firstNumber = input.ask("Введите первое число: ");
            double secondNumber = input.ask("Введите второе число: ");
            result = firstNumber + secondNumber;
            return result;
        }

        /**
         * Метод, прибавляющий к полученному ранее результату второе число.
         * @param input ввод пользователя.
         * @param firstNumber результат предыдущей операции.
         * @return сумма.
         */
        public double operation(Input input, double firstNumber) {
            double secondNumber = input.ask("Введите второе число: ");
            result = firstNumber + secondNumber;
            return result;
        }
    }

    /**
     * Класс вычитания чисел.
     */
    public class SubtractionOfNumbers implements ActionOfCalc {

        /**
         * Метод, возвращающий информацию о действии.
         * @return информация.
         */
        public String information() {
            return String.format("%s. %s", this.key(), "Вычитание.");
        }

        /**
         * Метод, возвращающий ключ для вычитания чисел.
         * @return ключ.
         */
        public int key() {
            return 2;
        }

        /**
         * Метод, возвращающий ключ последнего выполненного действия.
         * @return ключ.
         */
        public int setKey() {
            return this.key();
        }

        /**
         * Метод, вычитающий 2 числа.
         * @param input ввод пользователя.
         * @return результат вычитания.
         */
        public double operation(Input input) {
            double firstNumber = input.ask("Введите первое число: ");
            double secondNumber = input.ask("Введите второе число: ");
            result = firstNumber - secondNumber;
            return result;
        }

        /**
         * Метод, отнимающий от полученного ранее результата второе число.
         * @param input ввод пользователя.
         * @param firstNumber результат предыдущей операции.
         * @return разность.
         */
        public double operation(Input input, double firstNumber) {
            double secondNumber = input.ask("Введите второе число: ");
            result = firstNumber - secondNumber;
            return result;
        }
    }

    /**
     * Класс умножения чисел.
     */
    public class MultiplicationOfNumbers implements ActionOfCalc {

        /**
         * Метод, возвращающий информацию о действии.
         * @return информация.
         */
        public String information() {
            return String.format("%s. %s", this.key(), "Умножение.");
        }

        /**
         * Метод, возвращающий ключ для вычитания чисел.
         * @return ключ.
         */
        public int key() {
            return 3;
        }

        /**
         * Метод, возвращающий ключ последнего выполненного действия.
         * @return ключ.
         */
        public int setKey() {
            return this.key();
        }

        /**
         * Метод, умножающий 2 числа.
         * @param input ввод пользователя.
         * @return результат умножения.
         */
        public double operation(Input input) {
            double firstNumber = input.ask("Введите первое число: ");
            double secondNumber = input.ask("Введите второе число: ");
            result = firstNumber * secondNumber;
            return result;
        }

        /**
         * Метод, умножающий полученный ранее результат на второе число.
         * @param input ввод пользователя.
         * @param firstNumber результат предыдущей операции.
         * @return произведение.
         */
        public double operation(Input input, double firstNumber) {
            double secondNumber = input.ask("Введите второе число: ");
            result = firstNumber * secondNumber;
            return result;
        }
    }

    /**
     * Класс деления чисел.
     */
    public class DivisionOfNumbers implements ActionOfCalc {

        /**
         * Метод, возвращающий информацию о действии.
         * @return информация.
         */
        public String information() {
            return String.format("%s. %s", this.key(), "Деление.");
        }

        /**
         * Метод, возвращающий ключ для вычитания чисел.
         * @return ключ.
         */
        public int key() {
            return 4;
        }

        /**
         * Метод, возвращающий ключ последнего выполненного действия.
         * @return ключ.
         */
        public int setKey() {
            return this.key();
        }

        /**
         * Метод, делящий 2 числа.
         * @param input ввод пользователя.
         * @return результат деления.
         */
        public double operation(Input input) {
            double firstNumber = input.ask("Введите первое число: ");
            double secondNumber = input.ask("Введите второе число: ");
            result = firstNumber / secondNumber;
            return result;
        }

        /**
         * Метод, делящий ранее результат на второе число.
         * @param input ввод пользователя.
         * @param firstNumber результат предыдущей операции.
         * @return частное.
         */
        public double operation(Input input, double firstNumber) {
            double secondNumber = input.ask("Введите второе число: ");
            result = firstNumber / secondNumber;
            return result;
        }
    }

    /**
     * Класс повторного вызова предыдущей операции.
     */
    public class RepeatAction implements ActionOfCalc {

        /**
         * Метод, возвращающий информацию о действии.
         * @return информация.
         */
        public String information() {
            return String.format("%s. %s", this.key(), "Повторить.");
        }

        /**
         * Метод, возвращающий ключ действия.
         * @return ключ.
         */
        public int key() {
            return 5;
        }

        /**
         * Метод, возвращающий ключ последнего выполненного действия.
         * @return ключ.
         */
        public int setKey() {
            return actionOfCalc[mainKey - 1].setKey();
        }

        /**
         * Метод, вызывающий предыдущее действие.
         * @param input ввод пользователя.
         * @return результат деления.
         */
        public double operation(Input input) {
            return actionOfCalc[mainKey - 1].operation(input);
        }
    }

    /**
     * Класс, использующий предыдущий результат для следующий операции.
     */
    public class UseResult implements ActionOfCalc {

        /**
         * Метод, возвращающий информацию о действии.
         * @return информация.
         */
        public String information() {
            return String.format("%s. %s", this.key(), "Использовать результат.");
        }

        /**
         * Метод, возвращающий ключ действия.
         * @return ключ.
         */
        public int key() {
            return 6;
        }

        /**
         * Метод, возвращающий ключ повторяемого действия.
         * @return ключ.
         */
        public int setKey() {
            return this.key();
        }

        /**
         * Метод, вызывающий предыдущее действие.
         * @param input ввод пользователя.
         * @return результат деления.
         */
        public double operation(Input input) {
            System.out.println("Выберите действие, для которого использовать полученный ранее результат.");
            show();
            return actionOfCalc[input.ask("Select: ", new int[] {1, 2, 3, 4, 7}) - 1].operation(input, result);
        }
    }

    /**
     * Класс получения синуса числа.
     */
    public class SinusOfNumber implements ActionOfCalc {

        /**
         * Метод, возвращающий информацию о действии.
         * @return информация.
         */
        public String information() {
            return String.format("%s. %s", this.key(), "Синус.");
        }

        /**
         * Метод, возвращающий ключ для сложения чисел.
         * @return ключ.
         */
        public int key() {
            return 7;
        }

        /**
         * Метод, возвращающий ключ последнего выполненного действия.
         * @return ключ.
         */
        public int setKey() {
            return this.key();
        }

        /**
         * Метод, вычисляющий синус числа..
         * @param input ввод пользователя.
         * @return синус.
         */
        public double operation(Input input) {
            double firstNumber = input.ask("Введите число: ");
            result = Math.sin(firstNumber);
            return result;
        }

        /**
         * Метод, вычислящий синус полученного ранее результата.
         * @param input ввод пользователя.
         * @param firstNumber результат предыдущей операции.
         * @return синус.
         */
        public double operation(Input input, double firstNumber) {
            result = Math.sin(firstNumber);
            return result;
        }
    }
}