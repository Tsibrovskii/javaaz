package ru.tsibrovskii.examples.Bot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Класс сервера.
 */
public class Server {

    String[] answers = new String[]{"answer1", "answer2", "answer3", "answer4", "answer5"};
    int i = -1;
    int port = 7777;

    /**
     * Метод, возвращающий ответ от сервера.
     * @return ответ от сервера.
     */
    private String choiceAnswer() {
        i++;
        if (i > 4) {
            i = 0;
        }
        return answers[i];
    }

    /**
     * Метод для работы сервера.
     */
    public void serverMethod() {
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
                } else {
                    out.println(server.choiceAnswer());
                    out.println();
                }
            } while (!"exit".equals(ask));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Основной метод класса.
     * @param args массив аргументов.
     */
    public static void main(String[] args) {
        new Server().serverMethod();
    }
}
