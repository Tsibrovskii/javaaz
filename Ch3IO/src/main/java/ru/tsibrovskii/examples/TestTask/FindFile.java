package ru.tsibrovskii.examples.TestTask;

import com.google.common.base.Joiner;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Класс поиска файла.
 */
public class FindFile {

    private final String LN = System.getProperty("line.separator");

    /**
     * Метод, осуществляющий поиск файл в заданном директории.
     * @param directory директория для поиска.
     * @param fileName имя файла.
     * @param mask маска поиска.
     * @throws IOException исключение.
     */
    public void searchFile(String directory, String fileName, String mask, String log) throws IOException {
        if ("-f".equals(mask)) {
            searchFileFull(directory, fileName, log);
        }
        if ("-m".equals(mask)) {
            searchFileMask(directory, fileName, log);
        }
    }

    /**
     * Метод, осуществляющий поиск файла по полному совпадению имени.
     * @param directory директория.
     * @param fileName имя файла.
     * @throws IOException исключение.
     */
    public void searchFileFull(String directory, String fileName, String log) throws IOException {

        File fileSearch = new File(String.format("%s%s",".\\", log));
        fileSearch.delete();
        try (RandomAccessFile raf = new RandomAccessFile(fileSearch, "rw")) {
            File file = new File(directory);
            for (File sub : file.listFiles()) {
                if (sub.toPath().toFile().isFile()) {
                    String nameOfFile = sub.toString().substring(sub.toString().lastIndexOf("\\") + 1);
                    if (fileName.equals(nameOfFile)) {
                        if (raf.length() == 0) {
                            raf.writeBytes(sub.getPath());
                        } else {
                            raf.seek(raf.length());
                            raf.writeBytes(String.format("%s%s", LN, sub.getPath()));
                        }
                    }
                } else {
                    searchFileFull(sub.toString(), fileName, log);
                }
            }
        }
    }

    /**
     * Метод, осуществляющий поиск файла по маске.
     * @param directory директория.
     * @param fileName имя файла.
     * @throws IOException исключение.
     */
    public void searchFileMask(String directory, String fileName, String log) throws IOException {

        File fileSearch = new File(String.format("%s%s",".\\", log));
        fileSearch.delete();
        try (RandomAccessFile raf = new RandomAccessFile(fileSearch, "rw")) {
            File file = new File(directory);
            for (File sub : file.listFiles()) {
                if (sub.toPath().toFile().isFile()) {
                    if (sub.toString().endsWith(fileName)) {
                        if (raf.length() == 0) {
                            raf.writeBytes(sub.getPath());
                        } else {
                            raf.seek(raf.length());
                            raf.writeBytes(String.format("%s%s", LN, sub.getPath()));
                        }
                    }
                } else {
                    searchFileMask(sub.toString(), fileName, log);
                }
            }
        }
    }

    /**
     * Метод, возвращающий подсказку.
     * @return подсказка.
     */
    public String getPrompt() {
        return Joiner.on(LN).join(
                "Запстите приложение следующим образом:",
                "java -jar Ch3IO-1.0.jar -d <название папки> -n <имя файла> -m -o <имя файла>",
                "или",
                "java -jar Ch3IO-1.0.jar -d <название папки> -n <имя файла> -f -o <имя файла>,",
                "где \"-d\" - директория, в которой начинается поиск,",
                "\"-n\" - полное или частичное имя файла, \"-m\" - искать по частичному совпадению,",
                "\"-f\" - искать по полному совпадению, \"-o\" - имя файла результатов поиска."
        );
    }

    /**
     * Основной метод класса.
     * @param args аргументы.
     * @throws IOException исключение.
     */
    public static void main(String[] args) throws IOException {
        Validator validator = new Validator(args);
        FindFile findFile = new FindFile();
        if (validator.checkArgs()) {
            findFile.searchFile(args[1], args[3], args[4], args[6]);
        } else {
            System.out.println(findFile.getPrompt());
        }
    }
}
