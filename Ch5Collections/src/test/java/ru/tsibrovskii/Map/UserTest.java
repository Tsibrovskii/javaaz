package ru.tsibrovskii.Map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Тестовый класс.
 */
public class UserTest {

    @Test
    public void whenPutTwoUsersShouldReturnMap() {

        Map<User, Object> userMap = new HashMap<>();
        User first = new User("Ivan", 2, new GregorianCalendar(1990, 01, 11));
        User second = new User("Ivan", 2, new GregorianCalendar(1990, 01, 11));
        userMap.put(first, "first");
        userMap.put(second, "second");

        System.out.println(userMap.values());
    }
}
