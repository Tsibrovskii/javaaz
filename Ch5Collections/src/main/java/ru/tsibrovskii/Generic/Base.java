package ru.tsibrovskii.Generic;

/**
 * Базовый класс.
 */
public abstract class Base {

    private String Id;

    /**
     * Метод получения идентификатора.
     * @return идентификаторю
     */
    public String getId() {
        return this.Id;
    }

    /**
     * Метод установки идентификатора.
     * @param Id
     */
    public void setId(String Id) {
        this.Id = Id;
    }
}
