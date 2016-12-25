package ru.tsibrovskii.examples;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Класс, реализующий интерфейс Sort сортировки файла по длине строк.
 */
public class SortFile implements Sort {

    String separator = System.getProperty("line.separator");

    /**
     * Метод сортировки файла по длинам строк.
     * @param source исходный файл.
     * @param distance отсортированный файл.
     * @throws IOException исключение.
     */
    public void sort(File source, File distance) throws IOException {

        String firstName = "firstFile.txt";
        String secondName = "secondFile.txt";

        try (RandomAccessFile raf = new RandomAccessFile(source, "r")) {

            String str;
            boolean result;
            RandomAccessFile rafNew = new RandomAccessFile(distance, "rw");
            if ((str = raf.readLine()) != null) {
                rafNew.writeBytes(str);
            }
            while ((str = raf.readLine()) != null) {
                rafNew.writeBytes(String.format("%s%s", separator, str));
            }

            do {
                rafNew.seek(0);

                File firstFile = new File(firstName);
                File secondFile = new File(secondName);

                RandomAccessFile rafFirstFile = new RandomAccessFile(firstFile, "rw");
                RandomAccessFile rafSecondFile = new RandomAccessFile(secondFile, "rw");

                partitionByTwoFiles(distance, firstFile, secondFile);

                rafNew.close();
                distance.delete();
                distance = new File(distance.getName());
                rafNew = new RandomAccessFile(distance, "rw");

                rafFirstFile.seek(0);
                rafSecondFile.seek(0);

                result = mergeFiles(distance, firstFile, secondFile);



                rafFirstFile.close();
                firstFile.delete();

                rafSecondFile.close();
                secondFile.delete();
            } while (!result);
        }

    }

    /**
     * Метод разбиения файла на два подфайла.
     * @param sourceFile исходный файл.
     * @param firstFile первый подфайл.
     * @param secondFile второй подфайл.
     * @throws IOException исключение.
     */
    public void partitionByTwoFiles(File sourceFile, File firstFile, File secondFile) throws IOException {

        try (RandomAccessFile rafNew = new RandomAccessFile(sourceFile, "rw");
             RandomAccessFile rafFirstFile = new RandomAccessFile(firstFile, "rw");
             RandomAccessFile rafSecondFile = new RandomAccessFile(secondFile, "rw")) {

            /**
             * Условие, определяющее, в какой файл будет произведена запись.
             */
            boolean isFirstFileToWrite = true;

            String str1 = rafNew.readLine();
            String str2;

            /**
             * Счетчик для записи во второй файл.
             * Нужен для записи первой строки.
             */
            int forSecondFileCounter = 0;

            rafFirstFile.writeBytes(str1);
            while ((str2 = rafNew.readLine()) != null) {
                if (str2.length() < str1.length()) isFirstFileToWrite = !isFirstFileToWrite;
                if (isFirstFileToWrite) {
                    rafFirstFile.writeBytes(String.format("%s%s", separator, str2));
                    str1 = str2;
                } else {
                    forSecondFileCounter++;
                    if (forSecondFileCounter == 1) {
                        rafSecondFile.writeBytes(str2);
                        str1 = str2;
                    } else {
                        rafSecondFile.writeBytes(String.format("%s%s", separator, str2));
                        str1 = str2;
                    }
                }
            }
        }
    }

    /**
     * Метод слияния двух файлов по возрастанию элементов.
     * @param sourceFile результат.
     * @param firstFile первый файл.
     * @param secondFile второй файл.
     * @return условие окончательного слияния.
     * @throws IOException исключение.
     */
    public boolean mergeFiles(File sourceFile, File firstFile, File secondFile) throws IOException {

        try (RandomAccessFile rafNew = new RandomAccessFile(sourceFile, "rw");
             RandomAccessFile rafFirstFile = new RandomAccessFile(firstFile, "rw");
             RandomAccessFile rafSecondFile = new RandomAccessFile(secondFile, "rw")) {

            Boolean result = false;

            String str1 = rafFirstFile.readLine();
            String str2 = rafSecondFile.readLine();
            if (str2 == null) result = true;

            int forMerge = 0;

            while (str1 != null | str2 != null) {

                if (str1 != null && str2 != null) {
                    forMerge++;
                    if (str1.length() < str2.length()) {
                        if (forMerge == 1) {
                            rafNew.writeBytes(str1);
                        } else {
                            rafNew.writeBytes(String.format("%s%s", separator, str1));
                        }
                        str1 = rafFirstFile.readLine();
                    } else {
                        if (forMerge == 1) {
                            rafNew.writeBytes(str2);
                        } else {
                            rafNew.writeBytes(String.format("%s%s", separator, str2));
                        }
                        str2 = rafSecondFile.readLine();
                    }
                }
                if (str2 == null && str1 != null) {
                    forMerge++;
                    if (forMerge == 1) {
                        rafNew.writeBytes(str1);
                    } else {
                        rafNew.writeBytes(String.format("%s%s", separator, str1));
                    }
                    str1 = rafFirstFile.readLine();
                }
                if (str1 == null && str2 != null) {
                    forMerge++;
                    if (forMerge == 1) {
                        rafNew.writeBytes(str2);
                    } else {
                        rafNew.writeBytes(String.format("%s%s", separator, str2));
                    }
                    str2 = rafSecondFile.readLine();
                }
            }
            return result;
        }
    }

    /**
     * Основной метод.
     * @param args аргументы.
     * @throws IOException исключение.
     */
    public static void main(String[] args) throws IOException {

        String fileName = "random.txt";
        String fileName2 = "random2.txt";
        File f1 = new File(fileName);
        File f2 = new File(fileName2);
        SortFile sr = new SortFile();
        sr.sort(f1, f2);
    }
}
