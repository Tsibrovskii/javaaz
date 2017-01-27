package ru.tsibrovskii.examples.Bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Класс сервера.
 */
public class Server {

    /**
     * Основной метод класса.
     * @param args массив аргументов.
     */
    public static void main(String[] args) {
        int port = 7777;
        try {
            Socket socket =  new ServerSocket(port).accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String ask;
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                if ("hello".equals(ask)) {
                    out.println("Hello, dear friend, I'm a oracle.");
                    out.println();
                }
            } while ("exit".equals(ask));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
