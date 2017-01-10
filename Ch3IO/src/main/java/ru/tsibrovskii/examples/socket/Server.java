package ru.tsibrovskii.examples.socket;

import com.google.common.base.Joiner;
import com.google.common.base.Utf8;
import org.apache.commons.io.output.WriterOutputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс для работы сервера.
 */
public class Server {

    String separator = System.getProperty("line.separator");

    String mainCatalogue = "./";
    String catalogue = "./";

    /**
     * Метод возврата списка корневого каталога.
     * @return список корневого каталога.
     */
    public String returnMainCatalogue() {
        String str = null;
        Path ph = Paths.get(mainCatalogue);
        File file = new File(ph.toString());
        for (File sub : file.listFiles()) {
            if (str == null) {
                str = sub.toString();
            } else {
                str = String.format("%s%s%s", str, separator, sub);
            }
        }
        return str;
    }

    /**
     * Метод, возвращающий список выбранного подкаталога.
     * @param folder название подкаталога.
     * @return список подкаталога.
     */
    public String returnCatalogue(String folder) {
        String str = null;
        catalogue = catalogue + folder;
        Path ph = Paths.get(catalogue);
        File file = new File(ph.getParent().toString());
        for (File sub : file.listFiles()) {
            if (str == null) {
                str = sub.toString();
            } else {
                str = String.format("%s%s%s", str, separator, sub);
            }
        }
        return str;
    }

    /**
     * Основной метод.
     * @param args аргументы.
     */
    public static void main(String[] args) {
        int portNumber = 7777; // 1025-65535
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Ждем подключение к серверу.");
            Socket socket = serverSocket.accept();
            System.out.println("Подключение состоялось.");

            InputStream socketInputStream = socket.getInputStream();
            OutputStream socketOutputStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInputStream);
            DataOutputStream out = new DataOutputStream(socketOutputStream);

            WriterOutputStream wr = new WriterOutputStream(socketOutputStream, "UTF-8");

            Server srv = new Server();
            String choice = Joiner.on(srv.separator).join(
                    "1. Получение списка корневого каталога.",
                    "2. Получение списка подкаталога.",
                    "Выберите действие: ");

            while (true) {
                out.writeUTF(choice);
                if ("1".equals(in.readUTF())) {
                    out.writeUTF(srv.returnMainCatalogue());
                }
                if ("2".equals(in.readUTF())) {
                    out.writeUTF("Введите имя папки:");
                    String answer = in.readUTF();
                    out.writeUTF(srv.returnCatalogue(answer));
                }
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}