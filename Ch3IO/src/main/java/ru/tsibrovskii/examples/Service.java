package ru.tsibrovskii.examples;

import java.io.*;
import java.util.Scanner;

/**
 * Сервис для работы с байтовым потоком.
 */
public class Service {

    public boolean result;
    public byte buf[];

    /**
     * Метод, проверяющий байтовый поток на наличие четного числа.
     * @param in входной поток.
     * @return признак наличия в байтовом потоке четного числа.
     */
    public boolean isNumber(InputStream in) throws IOException {
        int i;
        try {
            while ((i = in.read()) != -1) {
                if (i % 2 == 0) {
                    result = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Main метод.
     * @param args входные аргументы.
     * @throws IOException исключение.
     */
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        Service service = new Service();

        ByteArrayOutputStream bOutput = new ByteArrayOutputStream(3);
        while (bOutput.size()!= 3) {
            String number = scanner.next();
            bOutput.write(number.getBytes());
        }
        byte b [] = bOutput.toByteArray();

        ByteArrayInputStream bInput = new ByteArrayInputStream(b);
        System.out.println(service.isNumber(bInput));

    }
}
