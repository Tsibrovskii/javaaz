package ru.tsibrovskii.examples.Bot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Класс сервера.
 */
public class Server {

    int i = -1;

    /**
     * Метод, возвращающий ответ от сервера.
     * @return ответ от сервера.
     */
    private String choiceAnswer() {
        i++;
        if (i > 4) {
            i = 0;
        }
        String[] answers = new String[]{"answer1", "answer2", "answer3", "answer4", "answer5"};
        return answers[i];
    }

    /**
     * Основной метод класса.
     * @param args массив аргументов.
     */
    public static void main(String[] args) {
        int port = 7777;
        try {
            Socket socket = new ServerSocket(port).accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String ask;
            Server server = new Server();
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                if ("hello".equals(ask)) {
                    out.println("Hello, dear friend, I'm a oracle.");
                    out.println();
                    out.flush();
                } else {
                    out.println(server.choiceAnswer());
                    out.println();
                    out.flush();
                }
            } while (!"exit".equals(ask));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
