package ru.tsibrovskii.examples;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

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

        String fileName = "C:\\projects\\javaaz\\Ch3IO\\random.txt";
        String fileName2 = "C:\\projects\\javaaz\\Ch3IO\\random2.txt";
        String fileTest = "C:\\projects\\javaaz\\Ch3IO\\randomRes.txt";
        File f1 = new File(fileName);
        File f2 = new File(fileName2);
        File fRes = new File(fileTest);
        sr.sort(f1, f2);

        //Assert.assertEquals(f1, fRes);
        /*
        File file = new File("./../");
        for (File sub: file.listFiles()) {
            System.out.println(sub);
        }
         */
    }
}
