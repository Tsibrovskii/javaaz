package ru.tsibrovskii.examples.Client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Класс для работы клиента.
 */
public class Client {

    /**
     * Основной метод.
     * @param args аргументы.
     */
    public static void main(String[] args) {
        int serverPort = 7777;
        String ipAdress = "127.0.0.1";

        try {
            InetAddress inetAddress = InetAddress.getByName(ipAdress);
            System.out.println("Подключаемся к серверу: " + serverPort);
            Socket socket = new Socket(inetAddress, serverPort);

            InputStream socketInputStream = socket.getInputStream();
            OutputStream socketOutputStrem = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInputStream);
            DataOutputStream out = new DataOutputStream(socketOutputStrem);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            System.out.println("Введите фразу для передачи серверу: ");

            while (true) {
                str = reader.readLine();
                out.writeUTF(str);
                out.flush();
                str = in.readUTF();
                System.out.println("Сервер прислал в ответ: " + str);
                System.out.println("Введите фразу для отправки на сервер: ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
