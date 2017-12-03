package ru.tsibrovskii.Tree;

/**
 * Класс компании.
 */
public class Company {

    public final Company parent;
    public final long employeeCount;

    /**
     * Конструктор класса.
     * @param parent родительский элемент.
     * @param employeeCount количество рабочих.
     */
    Company(Company parent, long employeeCount) {
        this.parent = parent;
        this.employeeCount = employeeCount;
    }
}
