package ru.tsibrovskii.Map;

/**
 * Класс справочника.
 */
public class Handbook<T, V> {

    private T[] keys = (T[]) new Object[16];
    private V[] values = (V[]) new Object[this.keys.length];

    private int count = 0;

    /**
     * Метод вставки элемента в спровочник.
     * @param key ключ.
     * @param value значение.
     * @return успешность операции.
     */
    public boolean insert(T key, V value) {

        if(this.count == this.keys.length) {
            this.increaseArray();
        }

        boolean result = false;

        int index = key.hashCode() & (this.keys.length - 1);

        if(this.keys[index] == null) {
            this.keys[index] = key;
            this.values[index] = value;
            this.count++;
            result = true;
        }

        return result;
    }

    /**
     * Метод получения значения.
     * @param key ключ.
     * @return значение.
     */
    public V getElement(T key) {
        return this.values[key.hashCode() & (this.keys.length - 1)];
    }

    /**
     * Метод удаления элемента из справочника.
     * @param key ключ.
     * @return успешность операции.
     */
    public boolean delete(T key) {

        boolean result = false;

        int index = key.hashCode() & (this.keys.length - 1);

        if (index < this.keys.length) {
            this.keys[index] = null;
            this.values[index] = null;
            this.count--;
            result = true;
        }

        return result;
    }

    /**
     * Метод расширения массива.
     */
    private void increaseArray() {
        T[] bigKeys = (T[]) new Object[this.keys.length * 2];
        V[] bigValues = (V[]) new OutOfMemoryError[this.keys.length * 2];
        for(T t : this.keys) {
            bigKeys[t.hashCode() & (bigKeys.length - 1)] = t;
            bigValues[t.hashCode() & (bigKeys.length - 1)] = this.values[t.hashCode() & (this.keys.length - 1)];
        }
        this.keys = bigKeys;
        this.values = bigValues;
    }
}
