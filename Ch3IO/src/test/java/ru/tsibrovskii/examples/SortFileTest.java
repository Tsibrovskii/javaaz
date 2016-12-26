package ru.tsibrovskii.examples;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import static org.hamcrest.CoreMatchers.is;

/**
 * Тестовый класс.
 */
public class SortFileTest {

    /**
     * Тестовый метод.
     * @throws IOException исключение.
     */
    @Test
    public void whenGiveNotSortetFileShouldPerformSortedFile() throws IOException {

        SortFile sr = new SortFile();

        String separator = System.getProperty("line.separator");

        File beforeSort = new File("./../random.txt");
        File afterSort = new File("./random2.txt");

        sr.sort(beforeSort, afterSort);

        String str;
        String res = "";

        int forTestCounter = 0;

        File ss = new File("./random2.txt");

        try (RandomAccessFile raf = new RandomAccessFile(ss, "rw")) {
            while ((str = raf.readLine()) != null) {
                forTestCounter++;
                if (forTestCounter != 1) {
                    res = String.format("%s%s%s", res, separator, str);
                } else {
                    res = String.format("%s%s", res, str);
                }
            }
        }

        String result = String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s", "1", separator, "22", separator,
                "333", separator, "4444", separator, "55555", separator, "666666", separator, "7777777", separator,
                "88888888", separator, "999999999");

        Assert.assertEquals(res, result);

        /*File file = new File("./../");
        for (File sub: file.listFiles()) {
            System.out.println(sub);
        }*/

    }
}
