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

    private final String LN = System.getProperty("line.separator");
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
            String choice = Joiner.on(LN).join(
                    "1. Список корневого каталога.",
                    "2. Перейти в подкаталог.",
                    "3. Перейти в родительский каталог.",
                    "4. Скопировать файл.",
                    "5. Завершение работы.");
            Catalogue catalogue = new Catalogue();
            do {
                System.out.println("wait command ...");
                out.println(choice);
                out.println();
                String ask = in.readLine();
                System.out.println(ask);
                if (ask.equals("1")) {
                    out.println(catalogue.returnMainCatalogue());
                }
                if (ask.equals("2")) {
                    out.println("Введите имя подкаталога.");
                    out.println();
                    out.println(catalogue.returnCatalogue(in.readLine()));
                }
                if (ask.equals("3")) {
                    out.println(catalogue.returnParentCatalogue());
                }
                if (ask.equals("4")) {
                    out.println("Введите имя файла, который вы хотите скопировать, в текущем каталоге.");
                    out.println();
                    String fileName = in.readLine();
                    out.println("Введите имя нового файла.");
                    out.println();
                    String newFileName = in.readLine();
                    out.println("copy");
                    out.println(newFileName);
                    CopyFileInSocket copyFileInSocket = new CopyFileInSocket(catalogue.getCurrentCatalogue(), fileName);
                    out.println(copyFileInSocket.lengthOfFile());
                    int i;
                    while ((i = copyFileInSocket.copyFile()) != -1) {
                        out.write(i);
                    }
                    out.println();
                }
                if (ask.equals("5")) {
                    out.println("exit");
                    break;
                }
                out.println("Нажмите ENTER для продолжения.");
                out.println();
                in.readLine();
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