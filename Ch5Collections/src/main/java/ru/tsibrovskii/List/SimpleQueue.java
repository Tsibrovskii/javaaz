package ru.tsibrovskii.List;

/**
 * Класс очереди.
 */
public class SimpleQueue<T> {

    DynamicLinkedList<T> dynamicList = new DynamicLinkedList<>();

    /**
     * Метод возвращения узлового элемента.
     * @param index позиция.
     * @return узел.
     */
    public DynamicLinkedList<T>.Node<T> getNode(int index) {
        DynamicLinkedList<T>.Node<T> findElement = dynamicList.getFirst();
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
        if(dynamicList.getLength() == 0) {
            return null;
        }
        if(dynamicList.getLength() == 1) {
            T t = (T) dynamicList.get(0);
            dynamicList.setLength(0);
            dynamicList.setFirst(null);
            return t;
        }
        T t = (T) dynamicList.get(0);
        this.getNode(1).setPrevious(null);
        dynamicList.setFirst(this.getNode(1));
        dynamicList.setLength(dynamicList.getLength()-1);
        return t;
    }

    /**
     * Метод добавления элемента в очередь.
     * @param t
     */
    public void push(T t) {
        dynamicList.add(t);
    }
}
