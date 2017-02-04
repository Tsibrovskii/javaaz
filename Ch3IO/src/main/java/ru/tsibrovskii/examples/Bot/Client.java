package ru.tsibrovskii.examples.Bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Класс клиента.
 */
public class Client {

    private final Socket socket;
    private static final int port = 7777;
    private static final String ip = "127.0.0.1";

    /**
     * Конструктора класса Клиента.
     * @param socket сокет.
     */
    public Client(Socket socket) {
        this.socket = socket;
    }

    /**
     * Метод для работы клиента.
     */
    public void clientMethod() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner console = new Scanner(System.in);
            do {
                String str;
                String answer = console.nextLine();
                if ("exit".equals(answer)) {
                    out.println(answer);
                    break;
                }
                out.println(answer);
                while (!(str = in.readLine()).isEmpty()) {
                    System.out.println(str);
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Основной метод класса.
     * @param args массив аргументов.
     */
    public static void main(String[] args) throws IOException {
        try (final Socket socket = new Socket(InetAddress.getByName(ip), port)) {
            new Client(socket).clientMethod();
        }
    }
}
