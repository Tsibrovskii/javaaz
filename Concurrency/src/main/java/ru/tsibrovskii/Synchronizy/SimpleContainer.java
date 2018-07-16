package ru.tsibrovskii.Synchronizy;

/**
 * Интерфейс контейнера.
 */
public interface SimpleContainer<E> extends Iterable<E> {

    void add(E e);

    E get(int index);
}
