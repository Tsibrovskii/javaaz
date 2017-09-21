package ru.tsibrovskii.List;

/**
 * Класс очереди.
 */
public class SimpleQueue<T> extends DynamicLinkedList<T> {

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
     * Метод получения первого элемента из очереди и удаления его из коллекции.
     * @param <T> тип возвращаемого элемента.
     * @return возвращаемый элемент.
     */
    public <T> T poll() {
        T t = (T) this.get(0);
        if(this.length > 1) {
            this.getNode(1).previous = null;
            this.first = this.getNode(1);
        }
        this.getNode(0).next = null;
        this.length--;
        return t;
    }

    /**
     * Метод добавления элемента в очередь.
     * @param t
     */
    public void push(T t) {
        this.add(t);
    }
}
