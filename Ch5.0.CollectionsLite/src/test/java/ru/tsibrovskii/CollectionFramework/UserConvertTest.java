package ru.tsibrovskii.CollectionFramework;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import ru.tsibrovskii.CollectionsFramework.User;
import ru.tsibrovskii.CollectionsFramework.UserConvert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Тестовый класс.
 */
public class UserConvertTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGiveListOfUsersShouldConvertIntoHashMap() {

        UserConvert userConvert = new UserConvert();

        HashMap<Integer, User> resultMap = new HashMap<>();
        User user1 = new User(1, "Ivan", "Paris");
        User user2 = new User(2, "Fedor", "London");
        User user3 = new User(3, "Paul", "Berlin");
        resultMap.put(1, user1);
        resultMap.put(2, user2);
        resultMap.put(3, user3);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        HashMap<Integer, User> convertedMap = userConvert.process(userList);

        assertThat(convertedMap, is(resultMap));
    }
}
