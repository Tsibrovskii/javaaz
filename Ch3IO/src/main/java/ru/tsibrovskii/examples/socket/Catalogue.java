package ru.tsibrovskii.examples.socket;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс для работы с каталогами.
 */
public class Catalogue {

    private final String LN = System.getProperty("line.separator");
    private String parentCatalogue;
    private String catalogue;
    private UserActions[] actions = new UserActions[6];
    private int position = 0;

    private PrintWriter out;
    private BufferedReader in;
    private OutputStream outputStream;

    /**
     * Конструктор класса по умолчанию.
     */
    public Catalogue(PrintWriter out, BufferedReader in, OutputStream outputStream) {
        this.out = out;
        this.in = in;
        this.outputStream = outputStream;
        initCatalogue();
    }

    /**
     * Метод инициализации пути корневого каталога.
     */
    public void initCatalogue() {
        Settings settings = new Settings();
        settings.load(Settings.class.getClassLoader().getResourceAsStream("app.properties"));
        Path ph = Paths.get(settings.getValue("home.path"));
        this.parentCatalogue = ph.toString();
        this.catalogue = this.parentCatalogue;
    }

    /**
     * Метод заполнения массива действий.
     */
    public void fillActions() {
        this.actions[position++] = this.new MainCatalogue();
        this.actions[position++] = this.new SubsidiaryCatalogue();
        this.actions[position++] = this.new ParentCatalogue();
        this.actions[position++] = this.new CurrentCatalogue();
        this.actions[position++] = this.new CopyFile();
        this.actions[position++] = this.new ExitCatalogue();
    }

    /**
     * Метод, выводящий меню действий.
     */
    public void showMenu() {
        for (UserActions action : this.actions) {
            if (action != null) {
                out.println(action.info());
            }
        }
        out.println();
    }

    /**
     * Метод для вызова выбранного пользователем действия.
     * @param key идентификатор (ключ) для выбранного действия.
     */
    public void select(int key) throws IOException {
        this.actions[key - 1].execute();
    }

    /**
     * Метод, возвращающий список каталога.
     * @return список каталога.
     */
    public String listOfCatalogue() {
        int length = this.catalogue.length();
        File file = new File(this.catalogue);
        String str = null;
        for (File sub : file.listFiles()) {
            String subStr = sub.toString().substring(length + 1);
            if (str == null) {
                str = subStr;
            } else {
                str = String.format("%s%s%s", str, LN, subStr);
            }
        }
        return str;
    }

    /**
     * Класс, предназначенный для вывода списка корневого каталога.
     */
    public class MainCatalogue implements UserActions {

        /**
         * Метод, возвращающий ключ.
         * @return ключ.
         */
        public int key() {
            return 1;
        }

        /**
         * Метод, возвращающий информацию о действии.
         * @return информация.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Список корневого каталога.");
        }

        /**
         * Метод, выполняющий печать в выходной поток списка корневого каталога.
         */
        public void execute() {
            catalogue = parentCatalogue;
            out.println(listOfCatalogue());
        }
    }

    /**
     * Класс, предназначенный для вывода списка выбранного подкаталога.
     */
    public class SubsidiaryCatalogue implements UserActions {

        /**
         * Метод, возвращающий ключ.
         * @return ключ.
         */
        public int key() {
            return 2;
        }

        /**
         * Метод, возвращающий информацию о действии.
         * @return информация.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Перейти в подкаталог.");
        }

        /**
         * Метод, выполняющий печать в выходной поток списка выбранного подкаталога.
         */
        public void execute() throws IOException {
            out.println("Введите имя подкаталога.");
            out.println();
            catalogue = String.format("%s\\%s", catalogue, in.readLine());
            out.println(listOfCatalogue());
        }
    }

    /**
     * Класс, предназначенный для вывода списка родительского каталога.
     */
    public class ParentCatalogue implements UserActions {

        /**
         * Метод, возвращающий ключ.
         * @return ключ.
         */
        public int key() {
            return 3;
        }

        /**
         * Метод, возвращающий информацию о действии.
         * @return информация.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Перейти в родительский каталог.");
        }

        /**
         * Метод, выполняющий печать в выходной поток списка родительского каталога.
         */
        public void execute() {
            if (!catalogue.equals(parentCatalogue)) {
                catalogue = catalogue.substring(0, catalogue.lastIndexOf("\\"));
            }
            out.println(listOfCatalogue());
        }
    }

    /**
     * Класс, предназначенный для вывода списка текущего каталога.
     */
    public class CurrentCatalogue implements UserActions {

        /**
         * Метод, возвращающий ключ.
         * @return ключ.
         */
        public int key() {
            return 4;
        }

        /**
         * Метод, возвращающий информацию о действии.
         * @return информация.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Получить текущий каталог.");
        }

        /**
         * Метод, выполняющий печать в выходной поток списка текущего каталога.
         */
        public void execute() {
            out.println(listOfCatalogue());
        }
    }

    /**
     * Класс, предназначенный для копирования файла.
     */
    public class CopyFile implements UserActions {

        /**
         * Метод, возвращающий ключ.
         * @return ключ.
         */
        public int key() {
            return 5;
        }

        /**
         * Метод, возвращающий информацию о действии.
         * @return информация.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Скопировать файл.");
        }

        /**
         * Метод, выполняющий печать в выходной поток списка текущего каталога.
         */
        public void execute() throws IOException {
            out.println("Введите имя файла, который вы хотите скопировать, в текущем каталоге.");
            out.println();
            String fileName = in.readLine();
            out.println("Введите имя нового файла.");
            out.println();
            String newFileName = in.readLine();
            out.println("copy");
            out.println(newFileName);
            out.println(catalogue);
            CopyFileInSocket copyFileInSocket = new CopyFileInSocket(catalogue, fileName);
            out.println(copyFileInSocket.lengthOfFile());
            int i;
            while ((i = copyFileInSocket.copyFile()) != -1) {
                outputStream.write(i);
            }
        }
    }

    /**
     * Класс, предназначенный для вывода списка текущего каталога.
     */
    public class ExitCatalogue implements UserActions {

        /**
         * Метод, возвращающий ключ.
         * @return ключ.
         */
        public int key() {
            return 6;
        }

        /**
         * Метод, возвращающий информацию о действии.
         * @return информация.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Завершение работы.");
        }

        /**
         * Метод, выполняющий выход из приложения.
         */
        public void execute() {
            out.println("exit");
        }
    }
}