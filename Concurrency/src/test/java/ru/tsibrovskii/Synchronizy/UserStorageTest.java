package ru.tsibrovskii.Synchronizy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserStorageTest {

    @Test
    public void whenTransferTenTimesShouldChangeValuesTenTimes() throws ExecutionException, InterruptedException {
        UserStorage userStorage = new UserStorage();
        User firstUser = new User(1, 15);
        User secondUser = new User(2, 5);
        userStorage.add(firstUser);
        userStorage.add(secondUser);

        int threads = 10;

        ExecutorService service = Executors.newFixedThreadPool(threads);
        CountDownLatch latch = new CountDownLatch(1);
        AtomicBoolean running = new AtomicBoolean();
        AtomicInteger overlaps = new AtomicInteger();
        Collection<Future<Integer>> futures = new ArrayList<>(threads);
        for (int t = 0; t < threads; ++t) {
            futures.add(
                service.submit(
                    () -> {
                        latch.await();
                        if (running.get()) {
                            overlaps.incrementAndGet();
                        }
                        running.set(true);
                        int count = 0;
                        if(userStorage.transfer(1, 2, 1)) {
                            count++;
                        }
                        running.set(false);
                        return count;
                    }
                )
            );
        }
        latch.countDown();
        for (Future<Integer> f : futures) {
            f.get();
        }

        assertThat(firstUser.getAmount(), is(5));
        assertThat(secondUser.getAmount(), is(15));
    }
}
