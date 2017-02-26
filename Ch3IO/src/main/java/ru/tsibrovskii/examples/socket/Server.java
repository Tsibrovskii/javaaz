package ru.tsibrovskii.examples.socket;

import com.google.common.base.Joiner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Класс для работы сервера.
 */
public class Server {

    private final Socket socket;

    /**
     * Конструктор класса Сервера.
     * @param socket сокет.
     */
    public Server(Socket socket) {
        this.socket = socket;
    }

    /**
     * Метод для работы сервера.
     */
    public void serverMethod() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Catalogue catalogue = new Catalogue(out, in, socket.getOutputStream());
            catalogue.fillActions();
            do {
                catalogue.showMenu();
                catalogue.select(Integer.valueOf(in.readLine()));
                out.println("Нажмите ENTER для продолжения.");
                out.println();
                if ("exit".equals(in.readLine())) {
                    break;
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Основной метод класса.
     * @param args параметры.
     * @throws IOException исключение.
     */
    public static void main(String[] args) throws IOException {
        Settings settings = new Settings();
        settings.load(Settings.class.getClassLoader().getResourceAsStream("app.properties"));
        try (final Socket socket = new ServerSocket(Integer.valueOf(settings.getValue("port"))).accept()) {
            new Server(socket).serverMethod();
        }
    }
}