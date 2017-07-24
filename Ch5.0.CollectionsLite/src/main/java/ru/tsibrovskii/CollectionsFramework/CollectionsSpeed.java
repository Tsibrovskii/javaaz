package ru.tsibrovskii.CollectionsFramework;

import java.util.*;

/**
 * Класс тестирования скорости коллекций.
 */
public class CollectionsSpeed {

    /**
     * Основной метод класса.
     * @param args аргументы.
     */
    public static void main(String[] args) {

        List<String> linkedList = new LinkedList<>();
        List<String> arrayList = new ArrayList<>();
        Set<String> treeSet = new TreeSet<>();

        CollectionsSpeed collectionsSpeed = new CollectionsSpeed();

        System.out.println(String.format("Время вставки в LinkedList: %s нс", collectionsSpeed.add(linkedList, 50000)));
        System.out.println(String.format("Время удаления из LinkedList: %s нс", collectionsSpeed.delete(linkedList, 10000)));

        System.out.println(String.format("Время вставки в ArrayList: %s нс", collectionsSpeed.add(arrayList, 50000)));
        System.out.println(String.format("Время удаления из ArrayList: %s нс", collectionsSpeed.delete(arrayList, 10000)));

        System.out.println(String.format("Время вставки в TreeSet: %s нс", collectionsSpeed.add(treeSet, 50000)));
        System.out.println(String.format("Время удаления из TreeSet: %s нс", collectionsSpeed.delete(treeSet, 10000)));
    }

    /**
     * Метод вставки элементов в коллекцию.
     * @param collection коллекция.
     * @param amount количество элементов.
     * @return время работы.
     */
    public long add(Collection<String> collection, int amount) {

        long startTime = System.nanoTime();
        for(int i = 0; i < amount; i++) {
            collection.add(((Integer) i).toString());
        }
        return (System.nanoTime() - startTime);
    }

    /**
     * Метод удаления элементов из коллекции.
     * @param collection коллекция.
     * @param amount количество элементов.
     * @return время работы.
     */
    public long delete(Collection<String> collection, int amount) {

        long startTime = System.nanoTime();
        for(int i = 0; i < amount; i++) {
            collection.remove(((Integer) (i*2)).toString());
        }
        return (System.nanoTime() - startTime);

    }
}
