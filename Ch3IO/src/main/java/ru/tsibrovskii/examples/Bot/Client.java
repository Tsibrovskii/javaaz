package ru.tsibrovskii.examples.Bot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Класс клиента.
 */
public class Client {

    /**
     * Основной метод класса.
     * @param args массив аргументов.
     */
    public static void main(String[] args) {
        int port = 7777;
        String ip = "127.0.0.1";

        try {
            Socket socket = new Socket(InetAddress.getByName(ip), port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner console = new Scanner(System.in);
            String str;
            do {
                out.println("Hello oracle");
                while (!(str = in.readLine()).isEmpty()) {
                    System.out.println(str);
                }
            } while (str != "stop");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
