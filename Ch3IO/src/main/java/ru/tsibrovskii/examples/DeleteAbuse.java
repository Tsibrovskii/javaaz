package ru.tsibrovskii.examples;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Класс удаления запрещенных слов.
 */
public class DeleteAbuse {

    /**
     * Строка, предназначенная для хранения прочитанного из потока.
     */
    private String str;
    /**
     * Условие наличия запрещенного слова в потоке.
     */
    private boolean isContainAbuse;

    /**
     * Метод удаления запрещенных слов из потока.
     * @param in входной поток.
     * @param out выходной поток.
     * @param abuse запрещенные слова.
     * @throws IOException исключение.
     */
    public void dropAbuse(InputStream in, OutputStream out, String[] abuse) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        while ((str = reader.readLine()) != null) {
            for (String abuseElement : abuse) {
                str = str.replaceAll(abuseElement, "");
            }
            out.write(str.getBytes());
        }
    }
}
