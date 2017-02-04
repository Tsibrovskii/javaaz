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

    private String[] answers = new String[]{"answer1", "answer2", "answer3", "answer4", "answer5"};

    private final Socket socket;
    private int i = -1;
    private static final int port = 7777;

    /**
     * Конструктор класса Сервера.
     * @param socket сокет.
     */
    public Server(Socket socket) {
        this.socket = socket;
    }

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
                } else if (!("exit".equals(ask))){
                    out.println(choiceAnswer());
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
    public static void main(String[] args) throws IOException {
        try (final Socket socket = new ServerSocket(port).accept()){
            new Server(socket).serverMethod();
        }
    }
}
