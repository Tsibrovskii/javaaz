package ru.tsibrovskii.examples.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Класс для работы клиента.
 */
public class Client {

    private final Socket socket;

    /**
     * Конструктора класса Клиента.
     *
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
                while (!(str = in.readLine()).isEmpty() && !"exit".equals(str) && !"copy".equals(str)) {
                    System.out.println(str);
                }
                if ("copy".equals(str)) {
                    String newFileName = in.readLine();
                    String catalogue = in.readLine();
                    long length = Long.valueOf(in.readLine());
                    File fileCopy = new File(String.format("%s\\%s", catalogue, newFileName));
                    try (RandomAccessFile raf = new RandomAccessFile(fileCopy, "rw")) {
                        while (raf.length() != length) {
                            raf.write(socket.getInputStream().read());
                        }
                    }
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                    }
                }
                if ("exit".equals(str)) {
                    out.println("exit");
                    break;
                }
                out.println(console.nextLine());
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
        Settings settings = new Settings();
        settings.load(Settings.class.getClassLoader().getResourceAsStream("app.properties"));
        try (final Socket socket = new Socket(InetAddress.getByName(settings.getValue("ip")),
                Integer.valueOf(settings.getValue("port")))) {
            new Client(socket).clientMethod();
        }
    }
}