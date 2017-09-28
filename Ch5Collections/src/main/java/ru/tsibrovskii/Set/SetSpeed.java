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
    public long add(Set<Long> collection, Long amount) {

        long startTime = System.currentTimeMillis();
        for(Long i = 0L; i < amount; i++) {
            collection.add(i);
        }

        for (Long i = 0L; i < amount; i++) {
            collection.add(3*i);
        }
        return (System.currentTimeMillis() - startTime);
    }

    /**
     * Основной метод класса.
     * @param args аргументы.
     */
    public static void main(String[] args) {

        SetSpeed setSpeed = new SetSpeed();

        HashSet<Long> hashSetCollection = new HashSet<>();
        TreeSet<Long> treeSetCollection = new TreeSet<>();
        LinkedHashSet<Long> linkedHashSetCollection = new LinkedHashSet<>();

        System.out.println("hashSetCollection time: " + setSpeed.add(hashSetCollection, 2000000L));
        System.out.println("treeSetCollection time: " + setSpeed.add(treeSetCollection, 2000000L));
        System.out.println("linkedHashSetCollection time: " + setSpeed.add(linkedHashSetCollection, 2000000L));
    }
}
