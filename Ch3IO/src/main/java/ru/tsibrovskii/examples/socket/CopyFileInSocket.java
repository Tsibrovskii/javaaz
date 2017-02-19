package ru.tsibrovskii.examples.socket;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Класс для копирования файла через сокет.
 */
public class CopyFileInSocket {

    private String catalogue;
    private String fileName;

    public CopyFileInSocket(String catalogue, String fileName) {
        this.catalogue = catalogue;
        this.fileName = fileName;
    }

    private long s = 0;

    public int copyFile() throws IOException {

        String fileToCopy = String.format("%s\\%s", this.catalogue, this.fileName);
        File fileCopy = new File(fileToCopy);
        int i;
        try (RandomAccessFile raf = new RandomAccessFile(fileCopy, "r")) {
            do {
                raf.seek(s);
                i = raf.read();
                s++;
                return i;
            } while (i != -1);
        }
    }

    /**
     * Метод, возвращающий длину файла.
     * @return длина файла.
     * @throws IOException исключение.
     */
    public long lengthOfFile() throws IOException {
        String fileToCopy = String.format("%s\\%s", this.catalogue, this.fileName);
        File fileCopy = new File(fileToCopy);
        int i;
        try (RandomAccessFile raf = new RandomAccessFile(fileCopy, "r")) {
            return raf.length();
        }
    }
}
