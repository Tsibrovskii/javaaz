package ru.tsibrovskii.Generic;

import java.lang.reflect.ParameterizedType;

public class SimpleList<T> {

    Object[] objects;
    int index = 0;

    public SimpleList(int size) {
        this.objects = new Object[size];
        Class<T> t = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            T value = t.newInstance();
            System.out.printf("this type is " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
