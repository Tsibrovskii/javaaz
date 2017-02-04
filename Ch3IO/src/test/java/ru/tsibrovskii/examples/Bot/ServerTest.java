package ru.tsibrovskii.examples.Bot;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Тестовый класс.
 */
public class ServerTest {

    private static final String LN = System.getProperty("line.separator");

    /**
     * Тестовый метод.
     * @throws IOException исключение.
     */
    @Test
    public void whenGiveInputStreamShouldReturnOutputStream() throws IOException {

        String inputString = Joiner.on(LN).join("hello", "hi", "something", "todo", "www", "http", "exit");
        String outputString = Joiner.on(LN).join(
                "Hello, dear friend, I'm a oracle.", "", "answer1", "", "answer2", "", "answer3", "", "answer4", "", "answer5", "", "");

        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        when(socket.getOutputStream()).thenReturn(out);
        when(socket.getInputStream()).thenReturn(in);
        Server server = new Server(socket);
        server.serverMethod();
        assertThat(out.toString(), is(outputString));
    }
}
