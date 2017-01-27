package ru.tsibrovskii.examples.socket;

import org.apache.commons.io.input.ReaderInputStream;
import org.apache.commons.io.output.WriterOutputStream;

import java.io.*;
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
        String ipAddress = "127.0.0.1";

        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            System.out.println("Подключаемся к серверу: " + serverPort);
            Socket socket = new Socket(inetAddress, serverPort);

            InputStream socketInputStream = socket.getInputStream();
            OutputStream socketOutputStream = socket.getOutputStream();

            ReaderInputStream readerStream = new ReaderInputStream(new InputStreamReader(socketInputStream), "UTF-8");
            WriterOutputStream writerStream = new WriterOutputStream(new OutputStreamWriter(socketOutputStream), "UTF-8");

            PrintWriter pWriter = new PrintWriter(writerStream, true);

            BufferedReader bufReader = new BufferedReader(new InputStreamReader(readerStream));

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            /*pWriter.write("Hello Server");
            pWriter.flush();
            socket.close();*/
            while (true) {
                pWriter.write("Get the menu");
                pWriter.flush();
                String str;
                while ((str = bufReader.readLine()) != null) {
                    System.out.println(str);
                }
                pWriter.write(reader.readLine());
                pWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
