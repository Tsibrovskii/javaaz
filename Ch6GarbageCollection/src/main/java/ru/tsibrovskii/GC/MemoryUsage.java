package ru.tsibrovskii.GC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.SoftReference;

/**
 * Класс работы со сборщиком мусора.
 */
public class MemoryUsage {

    //private static final Logger Log = LoggerFactory.getLogger(MemoryUsage.class);

    public static class User {
        /*public String name;

        public User(String name) {
            this.name = name;
        }

        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize");
        }*/
    }

    public static void main(String[] args) {
        //System.out.println("start");
        //info();
        //SoftReference<User> user = new SoftReference(new User("test"));
        //System.out.println(user.get().name);
        for (int i = 0; i < 1000; i++) {
            new User();
        }
        info();
        //System.gc();
        //System.out.println("finish");
        //info();
    }

    public static void info() {
        int mb = 1024 * 1024;

        //Getting the runtime reference from system.
        Runtime runtime = Runtime.getRuntime();

        System.out.println("##### Heap utilization statistics [MB] #####");

        //Print used memory.
        System.out.println("Used Memory:" + (runtime.totalMemory() - runtime.freeMemory()));

        //Print free memory.
        System.out.println("Free Memory:" + runtime.freeMemory());

        //Print total available memory.
        System.out.println("Total Memory:" + runtime.totalMemory());

        //Print Maximum available memory.
        System.out.println("Max Memory:" + runtime.maxMemory());
    }
}
