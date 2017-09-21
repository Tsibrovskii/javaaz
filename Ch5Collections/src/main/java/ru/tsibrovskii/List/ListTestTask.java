package ru.tsibrovskii.List;

/**
 * Класс узла.
 * @param <T> тип контейнера.
 */
class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
/**
 * Тестовое задание.
 */
public class ListTestTask<T> {

    /**
     * Метод проверки связанного списка на цикличность.
     * @param first первый элемент.
     * @return результат.
     */
    boolean hasCycle(Node<T> first) {

        Node<T> firstRunner = first;
        Node<T> secondRunner = first;

        while (firstRunner.next != null) {
            firstRunner = firstRunner.next;
            if(firstRunner.next == null) {
                return false;
            }
            firstRunner = firstRunner.next;
            secondRunner = secondRunner.next;
            if(firstRunner == secondRunner) {
                return true;
            }
        }

        return false;
    }
}
