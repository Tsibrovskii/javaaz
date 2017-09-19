package ru.tsibrovskii.List;

import java.util.Iterator;

/**
 * Динамический контейнер связанного списка.
 */
public class DynamicLinkedList<E> implements SimpleContainer<E> {

    Node<E> current;
    Node<E> previous;
    Node<E> first;

    /**
     * Метод добавления нового элемента.
     * @param e новый элемент.
     */
    public void add(E e) {
        if(this.previous == null) {
            this.first = new Node(null, e, null);
            this.previous = this.first;
        } else {
            this.current = new Node(this.previous, e, null);
            this.previous.next = this.current;
            this.previous = this.current;
        }
    }

    /**
     * Метод получения элемента связанного листа.
     * @param index индекс искомого элемента.
     * @return искомый элемент.
     */
    public E get(int index) {
        Node<E> findElement = this.first;
        for(int i = 0; i < index; i++) {
            findElement = findElement.next;
        }
        return findElement.element;
    }

    /**
     * Метод итератора.
     * @return итератор.
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> element;

            public boolean hasNext() {
                return element.next != null;
            }

            public E next() {
                if(this.element == null) {
                    this.element = first;
                } else {
                    this.element = this.element.next;
                }
                return this.element.element;
            }

            @Override
            public void remove() {

            }
        };
    }

    /**
     * Класс элемента.
     * @param <E> тип элемента.
     */
    public class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        Node(Node<E> previous, E element, Node<E> next) {
            this.previous = previous;
            this.element = element;
            this.next = next;
        }
    }
}
