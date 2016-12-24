package ru.tsibrovskii.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Интерфейс сортировки файла по возрастанию длин его строк.
 */
public interface Sort {

    /**
     * Метод сортировки файла.
     * @param source исходный файл.
     * @param distance отсортированный файл.
     */
    void sort(File source, File distance) throws IOException;
}
