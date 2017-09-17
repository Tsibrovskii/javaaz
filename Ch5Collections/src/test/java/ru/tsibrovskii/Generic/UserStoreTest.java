package ru.tsibrovskii.Generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Тестовый класс.
 */
public class UserStoreTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGiveUserShouldAddInArray() {

        UserStore userStore = new UserStore(1);

        User u = new User("Id = 12345");

        userStore.add(u);

        User result = (User) userStore.store.get(0);

        assertThat(result.getId(), is("Id = 12345"));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGiveUserShouldDeleteItFromArray() {

        UserStore userStore = new UserStore(2);

        User u1 = new User("Id = 12345");
        User u2 = new User("Id = 6789");

        userStore.add(u1);
        userStore.add(u2);

        userStore.delete("Id = 6789");

        User result = (User) userStore.store.get(1);

        assertTrue(result == null);

    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGiveIdAndUserShouldUpdate() {

        UserStore userStore = new UserStore(2);

        User u1 = new User("Id = 12345");
        User u2 = new User("Id = 6789");
        User u3 = new User("Id = 777");

        userStore.add(u1);
        userStore.add(u2);

        userStore.update("Id = 12345", u3);

        User result = (User) userStore.store.get(0);

        assertThat(result.getId(), is("Id = 777"));

    }

}
