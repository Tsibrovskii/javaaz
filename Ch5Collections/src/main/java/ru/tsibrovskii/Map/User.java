package ru.tsibrovskii.Map;

import java.util.Calendar;

/**
 * Класс юзера.
 */
public class User {

    private String name;
    private int children;
    private Calendar birthday;

    /**
     * Конструктор класса.
     * @param name имя.
     * @param children количество детей.
     * @param birthday день рождения.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

//    @Override
//    public int hashCode() {
//        return (this.name.hashCode() + this.birthday.hashCode()) * 31 + this.children;
//    }

    @Override
    public boolean equals(Object obj) {

        boolean isEquals = false;

        if(this == obj) {
            isEquals = true;
        }

        if(!isEquals && obj != null && this.getClass() == obj.getClass()) {
            User convertObj = (User) obj;
            if(this.name.equals(convertObj.name) && this.children == convertObj.children
                    && this.birthday.equals(convertObj.birthday)) {
                isEquals = true;
            }
        }

        return isEquals;
    }
}
