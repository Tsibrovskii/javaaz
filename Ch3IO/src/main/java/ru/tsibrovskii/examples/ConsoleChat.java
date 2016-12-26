package ru.tsibrovskii.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * Класс Консольный чат.
 */
public class ConsoleChat {

    String separator = System.getProperty("line.separator");

    /**
     * Метод для работы с консольным чатом.
     * @throws IOException исключение.
     */
    public void consoleChat() throws IOException {
        String str;
        String answerFromFile = null;
        boolean isNotStopped = true;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             RandomAccessFile log = new RandomAccessFile(new File("./log.txt"), "rw")) {
            do {
                str = br.readLine();
                if (str.equals("stop")) {
                    isNotStopped = false;
                }
                if (str.equals("continue")) {
                    isNotStopped = true;
                }
                if (str.equals("finish")) {
                    log.writeBytes(String.format("%s%s", str, separator));
                    break;
                }
                if (isNotStopped) {
                    answerFromFile = answerToChat(randomNumber(lenghtOfAnswersFile()));
                    System.out.println(answerFromFile);
                }
                log.writeBytes(String.format("%s%s", str, separator));
                if (answerFromFile != null && isNotStopped) {
                    log.writeBytes(String.format("%s%s", answerFromFile, separator));
                }
            } while (!str.equals("finish"));
        }
    }

    /**
     * Метод определения количества возможных ответов.
     * @return количество возможных ответов.
     * @throws IOException исключение.
     */
    public int lenghtOfAnswersFile() throws IOException {
        int i = 0;
        String str;
        try (RandomAccessFile raf = new RandomAccessFile(new File("./answers.txt"), "r")){
            while ((str = raf.readLine()) != null) {
                i++;
            }
        }
        return i;
    }

    /**
     * Метод генерации случайного числа из диапазона от 0 до i.
     * @param i верхняя граница диапазона.
     * @return случайное число.
     */
    public int randomNumber(int i) {
        Random rn = new Random();
        return rn.nextInt(i);
    }

    /**
     * Метод, возвращающий ответ в зависимости от сгенерированного числа.
     * @param i порядковый номер ответа из файла ответов.
     * @return ответ.
     * @throws IOException исключение.
     */
    public String answerToChat(int i) throws IOException {
        String str = "";
        try (RandomAccessFile raf = new RandomAccessFile(new File("./answers.txt"), "r")){
            for (int j = 0; j < i; j++) {
                str = raf.readLine();
            }
        }
        return str;
    }

    /**
     * Main метод.
     * @param args аргументы.
     * @throws IOException исключение.
     */
    public static void main(String[] args) throws IOException {
        ConsoleChat chat = new ConsoleChat();
        chat.consoleChat();
    }
}
