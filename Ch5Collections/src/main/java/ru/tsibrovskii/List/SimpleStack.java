package ru.tsibrovskii.List;

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
        Node<T> findElement = this.first;
        for(int i = 0; i < index; i++) {
            findElement = findElement.next;
        }
        return findElement;
    }

    /**
     * Метод получения последнего элемента из стека и удаления его из коллекции.
     * @param <T> тип возвращаемого элемента.
     * @return возвращаемый элемент.
     */
    public <T> T poll() {
        T t = (T) this.get(this.length-1);
        this.getNode(this.length-1).previous = null;
        if(this.length > 2) {
            this.getNode(this.length - 2).next = null;
        }
        this.length--;
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
