package ru.tsibrovskii.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Динамический контейнер связанного списка.
 */
public class DynamicLinkedList<E> implements SimpleContainer<E> {

    private Node<E> current;
    private Node<E> previous;
    private Node<E> first;
    private int length = 0;

    public Node<E> getFirst() {
        return this.first;
    }

    public void setFirst(Node<E> e) {
        this.first = e;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

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
        length++;
    }

    /**
     * Метод получения элемента связанного листа.
     * @param index индекс искомого элемента.
     * @return искомый элемент.
     */
    public E get(int index) {
        if (index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
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

            private Node<E> element;

            public boolean hasNext() {
                if(first == null) {
                    return false;
                } else {
                    return element.next != null;
                }
            }

            public E next() {
                if(this.element == null) {
                    this.element = first;
                } else if(this.element.next != null) {
                    this.element = this.element.next;
                } else {
                    throw new NoSuchElementException();
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
        private E element;
        private Node<E> next;
        private Node<E> previous;

        public Node(Node<E> previous, E element, Node<E> next) {
            this.previous = previous;
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return this.element;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setNext(Node<E> e) {
            this.next = e;
        }

        public Node<E> getPrevious() {
            return this.previous;
        }

        public void setPrevious(Node<E> e) {
            this.previous = e;
        }
    }
}
