package ru.tsibrovskii.List;

import java.util.NoSuchElementException;

/**
 * Класс стэка.
 */
public class SimpleStack<T> extends DynamicLinkedList<T> {

    /**
     * Метод возвращения узлового элемента.
     * @param index позиция.
     * @return узел.
     */
    public Node<T> getNode(int index) {
        Node<T> findElement = this.getFirst();
        for(int i = 0; i < index; i++) {
            findElement = findElement.getNext();
        }
        return findElement;
    }

    /**
     * Метод получения последнего элемента из стека и удаления его из коллекции.
     * @param <T> тип возвращаемого элемента.
     * @return возвращаемый элемент.
     */
    public <T> T poll() {
        if(this.getLength() == 0) {
            return null;
        }
        T t = (T) this.get(this.getLength()-1);
        this.getNode(this.getLength()-1).setPrevious(null);
        if(this.getLength() > 1) {
            this.getNode(this.getLength() - 2).setNext(null);
        }
        this.setLength(this.getLength()-1);
        return t;
    }

    /**
     * Метод добавления элемента в стэк.
     * @param t
     */
    public void push(T t) {
        this.add(t);
    }
}
