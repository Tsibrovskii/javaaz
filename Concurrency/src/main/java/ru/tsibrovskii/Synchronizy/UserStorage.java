package ru.tsibrovskii.Synchronizy;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.HashSet;

@ThreadSafe
public class UserStorage {

    @GuardedBy("this")
    private final HashMap<Integer, User> storage = new HashMap<>();

    public synchronized boolean add(User user) {
        boolean result = false;
        if(!this.storage.containsValue(user)) {
            this.storage.put(user.getId(), user);
            result = true;
        }
        return result;
    }

    private synchronized void update(User user, int amount) {
        user.update(amount);
    }

    public synchronized boolean delete(User user) {
        boolean result = false;
        if(this.storage.containsValue(user)) {
            this.storage.remove(user.getId());
            result = true;
        }
        return result;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        if(this.storage.keySet().containsAll(new HashSet<>(fromId, toId))) {
            update(this.storage.get(fromId), -amount);
            update(this.storage.get(toId), amount);
            result = true;
        }
        return result;
    }

    public HashMap<Integer, User> getStorage() {
        return this.storage;
    }
}
