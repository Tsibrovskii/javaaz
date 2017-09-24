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
        Node<T> findElement = this.getFirst();
        for(int i = 0; i < index; i++) {
            findElement = findElement.getNext();
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
        if(this.getLength() > 1) {
            this.getNode(1).setPrevious(null);
            this.setFirst(this.getNode(1));
        }
        this.getNode(0).setNext(null);
        this.setLength(this.getLength()-1);
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
