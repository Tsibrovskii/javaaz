package ru.tsibrovskii.Synchronizy;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class User {

    @GuardedBy("this")
    private int amount;
    private final int id;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }

    public int getAmount() {
        return this.amount;
    }

    public synchronized void update(int amount) {
        this.amount += amount;
    }
}
