package ru.tsibrovskii.CollectionsFramework.Comparation;

import java.util.*;

/**
 * Класс сортировки.
 */
public class SortUser {

    /**
     * Класс компаратора для сравнения по длине имени юзера.
     */
    public class UserLengthNameComparator implements Comparator<User> {

        @Override
        public int compare(User a, User b) {
            Integer i = a.name.length();
            Integer j = b.name.length();
            return i.compareTo(j);
        }
    }

    /**
     * Класс компаратора для сравнения по возрасту юзера.
     */
    public class UserAgeComparator implements Comparator<User> {

        @Override
        public int compare(User a, User b) {
            return a.age.compareTo(b.age);
        }
    }

    /**
     * Метод, выводящий отсортированную коллекцию.
     * @param users список юзеров.
     * @return отсортировання коллекция юзеров.
     */
    public Set<User> sort(List<User> users) {
        Set<User> sortedUsers = new TreeSet<>();
        sortedUsers.addAll(users);
        return sortedUsers;
    }

    /**
     * Метод сортировки коллекции по длине имени.
     * @param users список юзеров.
     * @return отсортированный список юзеров.
     */
    public List<User> sortNameLength(List<User> users) {

        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User a, User b) {
                        Integer i = a.name.length();
                        Integer j = b.name.length();
                        return i.compareTo(j);
                    }
                }
        );
        return users;
    }

    /**
     * Метод сортировки списка юзеров по длине имени и возрасту.
     * @param users список юзеров.
     * @return отсортированный список юзеров.
     */
    public List<User> sortByAllFields(List<User> users) {

        Comparator<User> sortComparator = new UserLengthNameComparator().thenComparing(new UserAgeComparator());
        users.sort(sortComparator);
        return users;
    }
}
