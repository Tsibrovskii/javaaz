package ru.tsibrovskii.examples.TestTask;

import com.google.common.base.Joiner;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Тестовый класс
 */
public class FindFileTest {

    private final String LN = System.getProperty("line.separator");

    /**
     * Тестовый метод.
     * @throws IOException исключение.
     */
    @Test
    public void whenGiveDirectoryAndFileNameShouldCompareFiles() throws IOException {

        FindFile findFile = new FindFile();
        findFile.searchFile("c:\\projects\\javaaz\\", "random.txt", "-f");
        String result = Joiner.on(LN).join("c:\\projects\\javaaz\\Ch3IO\\random.txt", "c:\\projects\\javaaz\\random.txt");
        String resFromLog = null;
        String readFromRaf;

        try (RandomAccessFile raf = new RandomAccessFile(".\\..\\log.txt", "rw")) {
            while ((readFromRaf = raf.readLine()) != null) {
                if (resFromLog == null) {
                    resFromLog = readFromRaf;
                } else {
                    resFromLog = String.format("%s%s%s", resFromLog, LN, readFromRaf);
                }
            }
        }
        Assert.assertEquals(resFromLog, result);
    }

    /**
     * Тестовый метод.
     * @throws IOException исключение.
     */
    @Test
    public void whenGiveDirectoryAndFileNameShouldCompareFilesWithMask() throws IOException {

        FindFile findFile = new FindFile();
        findFile.searchFile("c:\\projects\\javaaz\\Tracker\\src\\main\\java\\ru\\tsibrovskii\\models", ".java", "-m");
        String result = Joiner.on(LN).join(
                "c:\\projects\\javaaz\\Tracker\\src\\main\\java\\ru\\tsibrovskii\\models\\Comment.java",
                "c:\\projects\\javaaz\\Tracker\\src\\main\\java\\ru\\tsibrovskii\\models\\Item.java");
        String resFromLog = null;
        String readFromRaf;

        try (RandomAccessFile raf = new RandomAccessFile(".\\..\\log.txt", "rw")) {
            while ((readFromRaf = raf.readLine()) != null) {
                if (resFromLog == null) {
                    resFromLog = readFromRaf;
                } else {
                    resFromLog = String.format("%s%s%s", resFromLog, LN, readFromRaf);
                }
            }
        }
        Assert.assertEquals(resFromLog, result);
    }
}
