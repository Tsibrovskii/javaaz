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
                if(innerIt == null) {
                    if(it.hasNext()) {
                        innerIt = it.next();
                    } else {
                        return false;
                    }
                }

                if(innerIt.hasNext()) {
                    return true;
                } else if(it.hasNext()) {
                    innerIt = it.next();
                    if(innerIt.hasNext()) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            @Override
            public Integer next() {
                if(innerIt == null) {
                    if(it.hasNext()) {
                        innerIt = it.next();
                    } else {
                        return null;
                    }
                }

                if(innerIt.hasNext()) {
                    return innerIt.next();
                } else if(it.hasNext()) {
                    innerIt = it.next();
                    if(innerIt.hasNext()) {
                        return innerIt.next();
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            }
        };

    }
}
