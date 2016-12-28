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

    String[] arrayOfAnswers;

    final String STOP = "stop";
    final String CONTINUE = "continue";
    final String FINISH = "finish";

    /**
     * Метод для работы с консольным чатом.
     * @throws IOException исключение.
     */
    public void consoleChat() throws IOException {

        formationOfArrayFromFile();

        String str;
        String answerFromFile = null;
        boolean isNotStopped = true;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             RandomAccessFile log = new RandomAccessFile(new File("./log.txt"), "rw")) {
            do {
                str = br.readLine();
                if (STOP.equals(str)) {
                    isNotStopped = false;
                }
                if (CONTINUE.equals(str)) {
                    isNotStopped = true;
                }
                if (FINISH.equals(str)) {
                    log.writeBytes(String.format("%s%s", str, separator));
                    break;
                }
                if (isNotStopped) {
                    answerFromFile = arrayOfAnswers[randomNumber(arrayOfAnswers.length)];
                    System.out.println(answerFromFile);
                }
                log.writeBytes(String.format("%s%s", str, separator));
                if (isNotStopped) {
                    log.writeBytes(String.format("%s%s", answerFromFile, separator));
                }
            } while (!FINISH.equals(str));
        }
    }

    /**
     * Метод формирования массива строк из файла.
     * @throws IOException исключение.
     */
    public void formationOfArrayFromFile() throws IOException {
        int i = 0;
        try (RandomAccessFile raf = new RandomAccessFile(new File("./answers.txt"), "r")){
            while (raf.readLine() != null) {
                i++;
            }

            arrayOfAnswers = new String[i];
            raf.seek(0);
            for (int j = 0; j < i; j++) {
                arrayOfAnswers[j] = raf.readLine();
            }
        }
    }

    /**
     * Метод генерации случайного числа из диапазона от 0 до i-1.
     * @param i верхняя граница диапазона.
     * @return случайное число.
     */
    public int randomNumber(int i) {
        return new Random().nextInt(i);
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
