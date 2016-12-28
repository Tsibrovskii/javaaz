package ru.tsibrovskii.examples.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Класс для работы сервера.
 */
public class Server {

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
            OutputStream socketOutputStrem = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInputStream);
            DataOutputStream out = new DataOutputStream(socketOutputStrem);

            String str = null;

            while (true) {
                str = in.readUTF();
                System.out.println("Мы получили следующее сообщение: " + str);
                System.out.println("Отправка обратно");
                out.writeUTF(str);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
