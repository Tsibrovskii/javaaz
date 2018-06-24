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

    @Override
    public synchronized int hashCode() {
        return this.id + this.amount;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;

        if(this == obj) {
            isEquals = true;
        }

        if(!isEquals && obj != null && this.getClass() == obj.getClass()) {
            User convertObj = (User) obj;
            if(this.id == convertObj.id) {
                isEquals = true;
            }
        }

        return isEquals;
    }

    public int getId() {
        return this.id;
    }

    public synchronized int getAmount() {
        return this.amount;
    }

    public synchronized void update(int amount) {
        this.amount += amount;
    }
}
