package ru.tsibrovskii.Map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс справочника.
 */
public class Handbook<T, V> {

    /**
     * Класс ячейки.
     * @param <T> ключ.
     * @param <V> значение.
     */
    protected class MapHandbook<T, V> {

        private T key;
        protected V value;

        /**
         * Конструктор класса.
         * @param key ключ.
         * @param value значение.
         */
        private MapHandbook(T key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private MapHandbook[] mapArray = new MapHandbook[16];

    private int count = 0;

    /**
     * Метод вставки элемента в спровочник.
     * @param key ключ.
     * @param value значение.
     * @return успешность операции.
     */
    public boolean insert(T key, V value) {

        boolean result = false;

        if(key != null) {

            MapHandbook mHandbook = new MapHandbook(key, value);

            if (this.count == this.mapArray.length) {
                this.increaseArray();
            }

            int index = key.hashCode() & (this.mapArray.length - 1);

            if (this.mapArray[index] == null) {

                this.mapArray[index] = mHandbook;

                this.count++;

                result = true;
            }
        }

        return result;
    }

    /**
     * Метод получения значения.
     * @param key ключ.
     * @return значение.
     */
    public V getElement(T key) {

        int index = key.hashCode() & (this.mapArray.length - 1);

        if(this.mapArray[index] == null || !key.equals(this.mapArray[index].key)) {
            throw new NoSuchElementException();
        }

        return (V) this.mapArray[index].value;
    }

    /**
     * Метод удаления элемента из справочника.
     * @param key ключ.
     * @return успешность операции.
     */
    public boolean delete(T key) {

        boolean result = false;

        if(key != null) {

            int index = key.hashCode() & (this.mapArray.length - 1);

            if(key.equals(this.mapArray[index].key)) {
                this.mapArray[index] = null;
                this.count--;
                result = true;
            }

        }

        return result;
    }

    /**
     * Метод расширения массива.
     */
    private void increaseArray() {

        MapHandbook[] bigMap = new MapHandbook[this.mapArray.length * 2];

        for(MapHandbook mH : this.mapArray) {
            int index = mH.key.hashCode() & (bigMap.length - 1);
            bigMap[index] = mH;
        }
        this.mapArray = bigMap;
    }

    /**
     * Метод итератора.
     * @return итератор.
     */
    public Iterator<MapHandbook> iterator() {
        return new Iterator<MapHandbook>() {

            private int position = 0;
            private int iteratorCount = 0;

            public boolean hasNext() {

                boolean result = false;

                if(this.iteratorCount < count) {
                    result = true;
                }
                return result;
            }

            public MapHandbook next() {

                MapHandbook result = null;

                if (this.hasNext()) {
                    while (mapArray[this.position] == null) {
                        this.position++;
                    }
                    result = mapArray[this.position];
                    this.position++;
                    this.iteratorCount++;
                } else {
                    throw new NoSuchElementException();
                }

                return result;
            }
        };
    }
}
