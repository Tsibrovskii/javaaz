package ru.tsibrovskii.examples;

import java.io.IOException;
import java.io.InputStream;

/**
 * Сервис для работы с байтовым потоком.
 */
public class Service {

    /**
     * Значение результата работы класса.
     */
    private boolean result;

    /**
     * Метод, проверяющий байтовый поток на наличие четного числа.
     * @param in входной поток.
     * @return признак наличия в байтовом потоке четного числа.
     * @throws IOException исключение.
     */
    public boolean isNumber(InputStream in) throws IOException {
        int i;
        try {
            while ((i = in.read()) != -1) {
                if (Integer.valueOf(i) % 2 == 0) {
                    result = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
