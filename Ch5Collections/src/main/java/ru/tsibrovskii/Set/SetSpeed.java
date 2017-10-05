package ru.tsibrovskii.Set;

import java.util.*;

/**
 * Класс проверки скорости работы разных реализаций множеств.
 */
public class SetSpeed {

    /**
     * Метод вставки элементов в множествою
     * @param collection множество.
     * @param amount параметр размера.
     * @return время вставки.
     */
    public long add(Set<Integer> collection, Integer amount) {

        long startTime = System.currentTimeMillis();
        for(int i = 0; i < amount; i++) {
            collection.add(i);
        }

        return (System.currentTimeMillis() - startTime);
    }

    /**
     * Основной метод класса.
     * @param args аргументы.
     */
    public static void main(String[] args) {

        SetSpeed setSpeed = new SetSpeed();

        HashSet<Integer> hashSetCollection = new HashSet<>();
        TreeSet<Integer> treeSetCollection = new TreeSet<>();
        LinkedHashSet<Integer> linkedHashSetCollection = new LinkedHashSet<>();

        System.out.println("hashSetCollection time: " + setSpeed.add(hashSetCollection, 5000000));
        System.out.println("treeSetCollection time: " + setSpeed.add(treeSetCollection, 5000000));
        System.out.println("linkedHashSetCollection time: " + setSpeed.add(linkedHashSetCollection, 5000000));
    }
}
