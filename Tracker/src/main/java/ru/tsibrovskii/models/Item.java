package ru.tsibrovskii.models;

/**
 * Класс предназначен для хранения сущности типа "заявка".
 * Приватное поле id предназначено для хранения идентификатора сущности.
 * Публичные поля name, description, create используются для хранения
 * имени, описания и даты создания сущности, соответственно.
 */

public class Item {

    private String id;

    public String name;
    public String description;
    public long create;

    /**
     * Конструктор класса по умолчанию.
     */
    public Item() {
    }

    /**
     * Конструктор класса с 3-мя входящими параметрами.
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * Геттер имени заявки.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Геттер описания заявки.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Геттер даты создания заявки.
     */
    public long getCreate() {
        return this.create;
    }

    /**
     * Геттер идентификатора заявки.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Сеттер идентификатора заявки.
     */
    public void setId(String id) {
        this.id = id;
    }
}
