package ru.tsibrovskii.Iterator;

import java.util.Iterator;

/**
 * Класс итератора итераторов.
 */
public class Converter {

    /**
     * Метод преобразования итератора итераторов в итератор.
     * @param it итератор итераторов.
     * @return итератор.
     */
    public Iterator<Integer> convert(final Iterator<Iterator<Integer>> it) {

        /**
         * Анонимный внутренний класс.
         */
        return new Iterator<Integer>() {

            Iterator<Integer> innerIt;

            @Override
            public boolean hasNext() {
                return it.hasNext() || (innerIt != null && innerIt.hasNext());
            }

            @Override
            public Integer next() {

                if (hasNext()) {
                    if(innerIt == null || !innerIt.hasNext()) {
                        innerIt = it.next();
                    }
                    return innerIt.next();
                } else {
                    return null;
                }
            }

        };

    }
}
