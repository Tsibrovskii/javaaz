package ru.tsibrovskii.Synchronizy;

public class UserStorageTest {

    private class ThreadUserStorage extends Thread {
        private final UserStorage userStorage;

        private ThreadUserStorage(final UserStorage userStorage) {
            this.userStorage = userStorage;
        }

        @Override
        public void run() {
        }
    }
}
