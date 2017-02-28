package ru.tsibrovskii.examples.TestTask;

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
    public void searchFile(String directory, String fileName, String mask) throws IOException {
        if ("-f".equals(mask)) {
            searchFileFull(directory, fileName);
        }
        if ("-m".equals(mask)) {
            searchFileMask(directory, fileName);
        }
    }

    /**
     * Метод, осуществляющий поиск файла по полному совпадению имени.
     * @param directory директория.
     * @param fileName имя файла.
     * @throws IOException исключение.
     */
    public void searchFileFull(String directory, String fileName) throws IOException {

        File fileSearch = new File(".\\log.txt");
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
                    searchFileFull(sub.toString(), fileName);
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
    public void searchFileMask(String directory, String fileName) throws IOException {

        File fileSearch = new File(".\\log.txt");
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
                    searchFileMask(sub.toString(), fileName);
                }
            }
        }
    }

    /**
     * Основной метод класса.
     * @param args аргументы.
     * @throws IOException исключение.
     */
    public static void main(String[] args) throws IOException {
        FindFile findFile = new FindFile();
        findFile.searchFile("c:\\projects\\javaaz\\", "random.txt", args[0]);
    }
}
