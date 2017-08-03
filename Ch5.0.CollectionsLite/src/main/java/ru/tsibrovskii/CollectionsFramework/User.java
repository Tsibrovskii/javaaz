package ru.tsibrovskii.CollectionsFramework;

/**
 * Класс User.
 */
public class User {

    Integer id;
    String name;
    String city;

    /**
     * Конструктор класса.
     * @param id идентификатор.
     * @param name имя.
     * @param city город.
     */
    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}
