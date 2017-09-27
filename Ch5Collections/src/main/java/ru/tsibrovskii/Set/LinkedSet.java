package ru.tsibrovskii.Set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс связанного множества.
 */
public class LinkedSet<E> implements SimpleSet<E> {

    private Node<E> current;
    private Node<E> previous;
    private Node<E> first;
    private int length = 0;

    public int getLength() {
        return this.length;
    }

    /**
     * Метод добавления нового элемента.
     * @param e новый элемент.
     */
    public void add(E e) {
        if(this.first == null) {
            this.first = new Node(e, null);
            this.previous = this.first;
            length++;
            return;
        }
        Node<E> forAdd = this.first;
        for(int i = 0; i < this.length; i++) {
            if(e.equals(forAdd.getElement())) {
                return;
            }
            forAdd = forAdd.next;
        }

        this.current = new Node(e, null);
        this.previous.next = this.current;
        this.previous = this.current;

        length++;
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
                }
                if(this.element == null) {
                    return true;
                }

                return this.element.next != null;
            }

            public E next() {
                if(this.element == null && first != null) {
                    this.element = first;
                    return this.element.element;
                } else if(this.element != null && this.element.next != null) {
                    this.element = this.element.next;
                } else {
                    throw new NoSuchElementException();
                }

                return this.element.element;
            }
        };
    }

    /**
     * Класс элемента.
     * @param <E> тип элемента.
     */
    private class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
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
    }

}
