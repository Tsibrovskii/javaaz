package ru.tsibrovskii.Set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс связанного множества.
 */
public class LinkedSet<E> implements SimpleSet<E> {

    private Node<E> current;
    private Node<E> tail;
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

        if(this.first != null) {
            Node<E> forAdd = this.first;
            Boolean duplicate = false;
            int i = 0;
            while (!duplicate && i < this.length) {
                if (e.equals(forAdd.getElement())) {
                    duplicate = true;
                }
                forAdd = forAdd.next;
                i++;
            }

            if (!duplicate) {
                this.current = new Node(e, null);
                this.tail.next = this.current;
                this.tail = this.current;
                length++;
            }
        } else {
            this.first = new Node(e, null);
            this.tail = this.first;
            length++;
        }
    }

    /**
     * Метод итератора.
     * @return итератор.
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> element;

            public boolean hasNext() {

                return first == null ? false : (this.element == null ? true : this.element.next != null);
            }

            public E next() {
                if(this.element != null && this.element.next != null) {
                    this.element = this.element.next;
                } else if(this.element == null && first != null) {
                    this.element = first;
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
