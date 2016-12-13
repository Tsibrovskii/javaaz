package ru.tsibrovskii.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String str;

        while ((str = reader.readLine()) != null) {
            try {
                int i = Integer.valueOf(str);
                if (i % 2 == 0) {
                    result = true;
                    break;
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }

        return result;
    }
}
