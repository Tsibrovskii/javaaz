package ru.tsibrovskii.CollectionFramework.Comparation;

import org.junit.Test;
import ru.tsibrovskii.CollectionsFramework.Comparation.SortUser;
import ru.tsibrovskii.CollectionsFramework.Comparation.User;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс.
 */
public class SortUserTest {

    /**
     * Тестовый класс.
     */
    @Test
    public void whenGiveListOfUsersShouldReturnTreeSet() {

        SortUser sortUser = new SortUser();

        User fedor = new User("fedor", 17);
        User ivan = new User("ivan", 24);
        User lev = new User("lev", 11);

        Set<User> resultUser = new TreeSet<>();
        resultUser = sortUser.sort(Arrays.asList(fedor, ivan, lev));

        ArrayList<User> sortedUser = new ArrayList<>();
        for(User user : resultUser) {
            sortedUser.add(user);
        }

        assertThat(sortedUser.get(0), is(lev));
        assertThat(sortedUser.get(1), is(fedor));
        assertThat(sortedUser.get(2), is(ivan));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGiveListOfUsersShouldReturnSortedByLengthOfNameList() {

        SortUser sortUser = new SortUser();

        User fedor = new User("fedor", 17);
        User ivan = new User("ivan", 24);
        User lev = new User("lev", 11);

        List<User> resultUser = new ArrayList<>();
        resultUser = sortUser.sortByAllFields(Arrays.asList(fedor, ivan, lev));

        assertThat(resultUser.get(0), is(lev));
        assertThat(resultUser.get(1), is(ivan));
        assertThat(resultUser.get(2), is(fedor));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGiveLiseOfUsersShouldReturnSortedListByLengthOfNameAndAgeList() {

        SortUser sortUser = new SortUser();

        User fedor = new User("fedor", 17);
        User ivan = new User("ivan", 24);
        User leva = new User("leva", 11);

        List<User> resultUser = new ArrayList<>();
        resultUser = sortUser.sortByAllFields(Arrays.asList(fedor, ivan, leva));

        assertThat(resultUser.get(0), is(leva));
        assertThat(resultUser.get(1), is(ivan));
        assertThat(resultUser.get(2), is(fedor));
    }
}
