package ru.tsibrovskii.CollectionsFramework.Comparation;

/**
 * Класс юзера.
 */
public class User implements Comparable<User>{

    public String name;
    public Integer age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }
}
