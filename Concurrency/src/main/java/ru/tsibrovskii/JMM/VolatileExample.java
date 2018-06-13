package ru.tsibrovskii.JMM;

public class VolatileExample {

    private static int value = 0;

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int localValue = value;
            while (localValue < 5) {
                if(localValue != value) {
                    localValue = value;
                    System.out.println("ChangeListener class; localValue = " + localValue);
                }
            }
        }
    }

    static class ChangeMaker extends Thread {
        @Override
        public void run() {
            int localValue = value;
            while (value < 5) {
                value = ++localValue;
                System.out.println("ChangeMaker class; value = " + value);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }
}
