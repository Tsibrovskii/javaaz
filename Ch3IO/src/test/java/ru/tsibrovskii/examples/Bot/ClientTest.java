package ru.tsibrovskii.examples.Bot;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Тестовый класс.
 */
public class ClientTest {

    private static final String LN = System.getProperty("line.separator");

    /**
     * Тестовый метод.
     * @throws IOException исключение.
     */
    @Test
    public void whenGiveInputStreamShouldReturnInputStream() throws IOException {

        String inputString = Joiner.on(LN).join("hello", "exit");

        Socket socket = mock(Socket.class);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        when(socket.getOutputStream()).thenReturn(out);
        when(socket.getInputStream()).thenReturn(in);

        Client client = new Client(socket);

        String test = reader.readLine();
        String str;
        while ((str = reader.readLine()) != null) {
            test = String.format("%s%s%s", test, LN, str);
        }

        assertThat(test, is(inputString));
    }
}
