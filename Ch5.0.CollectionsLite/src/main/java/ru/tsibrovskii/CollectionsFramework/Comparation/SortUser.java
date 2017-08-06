package ru.tsibrovskii.CollectionsFramework.Comparation;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс сортировки.
 */
public class SortUser {

    private Set<User> sortedUsers = new TreeSet<>();

    /**
     * Метод, выводящий отсортированную коллекцию.
     * @param users список юзеров.
     * @return отсортировання коллекция юзеров.
     */
    public Set<User> sort(List<User> users) {
        sortedUsers.addAll(users);
        return sortedUsers;
    }
}
