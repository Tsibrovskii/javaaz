package ru.tsibrovskii.start;

public interface UserAction {

    int key();

    void execute(Input input, Tracker tracker); //это действия из технического задания к трекеру

    String info(); //печатает инфу о том, что метод делает
}