package ru.tsibrovskii.examples;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.google.common.base.Joiner;

/**
 * Тестовый класс.
 */
public class ConsoleChatTest {

    /**
     * Тестовый метод.
     * @throws IOException
     */
    @Test
    public void whenStartChatShouldPerformLogFile() throws IOException {

        ConsoleChat consTest = new ConsoleChat() {
            int j = 0;
            public int randomNumber(int i) {
                if (j < 9) {
                    return j++;
                } else {
                    return j;
                }
            }
        };

        String separator = System.getProperty("line.separator");

        ByteArrayInputStream chat = new ByteArrayInputStream((String.format("%s%s%s%s%s%s%s%s%s%s%s",
                "hello", separator,
                "world", separator,
                "stop", separator,
                "stop", separator,
                "continue", separator,
                "finish").getBytes()));

        System.setIn(chat);
        consTest.consoleChat();

        String res = null;
        String str = null;
        try (RandomAccessFile log = new RandomAccessFile(new File("./log.txt"), "rw")) {
            log.seek(0);
            if ((str = log.readLine()) != null) {
                res = str;

                while ((str = log.readLine()) != null) {
                    res = String.format("%s%s%s", res, separator, str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String resultStr = Joiner.on(separator).join("hello", "answer1", "world", "answer2", "stop", "stop",
                "continue", "answer3", "finish");

        Assert.assertEquals(res, resultStr);
    }
}
