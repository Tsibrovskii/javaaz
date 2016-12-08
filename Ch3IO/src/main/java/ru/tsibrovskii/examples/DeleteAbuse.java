package ru.tsibrovskii.examples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Класс удаления запрещенных слов.
 */
public class DeleteAbuse {

    /**
     * Метод удаления запрещенных слов из потока.
     * @param in входной поток.
     * @param out выходной поток.
     * @param abuse запрещенные слова.
     */
    public void dropAbuse(InputStream in, OutputStream out, String[] abuse) throws IOException {

        int i;
        try {
            while ((i = in.read()) != -1) {
                for (String abuseWord : abuse) {
                    if (!abuseWord.equals(String.valueOf(i))) {
                        out.write(i);
                        System.out.println((char) i);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
