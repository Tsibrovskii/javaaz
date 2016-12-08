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
                if (Integer.valueOf(i) % 2 == 0) {
                    result = true;
                }
                /*if (i % 2 == 0) {
                    result = true;
                }*/
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

        Service service = new Service();

        /*ByteArrayOutputStream bOutput = new ByteArrayOutputStream(1);

        Scanner scanner = new Scanner(System.in);
        while (bOutput.size()!= 3) {
            String number = scanner.next();
            bOutput.write(number.getBytes());
        }
        byte b [] = bOutput.toByteArray();*/

        ByteArrayInputStream bInput = new ByteArrayInputStream("2".getBytes());
        //System.setIn(bInput);
        System.out.println(service.isNumber(bInput));

        /*for (byte bb : b) {
            System.out.println((char) bb);
        }
        while (scanner.hasNext()) {
            //System.out.print(scanner.next());
            System.out.println();
            System.out.println(scanner.nextLine().length());
        }*/
    }
}
