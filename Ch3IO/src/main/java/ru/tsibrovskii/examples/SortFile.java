package ru.tsibrovskii.examples;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Класс, реализующий интерфейс Sort сортировки файла по длине строк.
 */
public class SortFile implements Sort {

    /**
     * Метод сортировки файла по длинам строк.
     * @param source исходный файл.
     * @param distance отсортированный файл.
     * @throws IOException исключение.
     */
    public void sort(File source, File distance) throws IOException {

        String firstName = "firstFile.txt";
        String secondName = "secondFile.txt";

        String separator = System.getProperty("line.separator");

        try (RandomAccessFile raf = new RandomAccessFile(source, "r")) {

            String str;
            long len;
            RandomAccessFile rafNew = new RandomAccessFile(distance.getName(), "rw");
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

                RandomAccessFile rafFirstFile = new RandomAccessFile(firstName, "rw");
                RandomAccessFile rafSecondFile = new RandomAccessFile(secondName, "rw");

                String str1 = rafNew.readLine();
                String str2;
                rafFirstFile.writeBytes(String.format("%s%s", str1, separator));

                boolean isFirstFileToWrite = true;



                while ((str2 = rafNew.readLine()) != null) {
                    if (str2.length() < str1.length()) isFirstFileToWrite = !isFirstFileToWrite;
                    if (isFirstFileToWrite) {
                        rafFirstFile.writeBytes(String.format("%s%s", str2, separator));
                        str1 = str2;
                    } else {
                        rafSecondFile.writeBytes(String.format("%s%s", str2, separator));
                        str1 = str2;
                    }
                }

                rafNew.close();
                distance.delete();
                distance = new File(distance.getName());
                rafNew = new RandomAccessFile(distance, "rw");

                rafFirstFile.seek(0);
                rafSecondFile.seek(0);

                str1 = rafFirstFile.readLine();
                str2 = rafSecondFile.readLine();
                while (distance.length() != (rafFirstFile.length() + rafSecondFile.length())) {

                    if (str1 != null && str2 != null) {
                        if (str1.length() < str2.length()) {
                            rafNew.writeBytes(String.format("%s%s", str1, separator));
                            str1 = rafFirstFile.readLine();
                        } else {
                            rafNew.writeBytes(String.format("%s%s", str2, separator));
                            str2 = rafSecondFile.readLine();
                        }
                    }
                    if (str2 == null && str1 != null) {
                        rafNew.writeBytes(String.format("%s%s", str1, separator));
                        str1 = rafFirstFile.readLine();
                    }
                    if (str1 == null && str2 != null) {
                        rafNew.writeBytes(String.format("%s%s", str2, separator));
                        str2 = rafSecondFile.readLine();
                    }

                }

                len = rafSecondFile.length();
                rafNew.seek(0);
                rafFirstFile.close();
                firstFile.delete();
                rafSecondFile.close();
                secondFile.delete();
            } while (len != 0);
        }
    }

    public static void main(String[] args) throws IOException {

        String fileName = "random.txt";
        String fileName2 = "random2.txt";
        File f1 = new File(fileName);
        File f2 = new File(fileName2);
        SortFile sr = new SortFile();
        sr.sort(f1, f2);
    }
}
