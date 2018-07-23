package ru.tsibrovskii.Synchronizy;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class DynamicListTest {

    @Test
    public void whenAddFourTimesShouldPopulateArrayByFourValues() throws ExecutionException, InterruptedException {
        DynamicList<String> dynamicList = new DynamicList<>();

        int threads = 4;

        ExecutorService service = Executors.newFixedThreadPool(threads);
        CountDownLatch latch = new CountDownLatch(1);
        AtomicBoolean running = new AtomicBoolean();
        AtomicInteger overlaps = new AtomicInteger();
        Collection<Future<Integer>> futures = new ArrayList<>(threads);
        for (int t = 0; t < threads; ++t) {
            int finalT = t;
            futures.add(
                    service.submit(
                            () -> {
                                latch.await();
                                if (running.get()) {
                                    overlaps.incrementAndGet();
                                }
                                running.set(true);
                                int count = 0;
                                dynamicList.add("value" + finalT);
                                count++;
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

        Set<String> valuesSet = new HashSet<>();
        for(int i = 0; i < 4; i++) {
            valuesSet.add(dynamicList.get(i));
        }

        assertTrue(valuesSet.contains("value0"));
        assertTrue(valuesSet.contains("value1"));
        assertTrue(valuesSet.contains("value2"));
        assertTrue(valuesSet.contains("value3"));
    }

    @Test
    public void whenIterateFourTimesShouldReturnAllValues() throws ExecutionException, InterruptedException {
        DynamicList<String> dynamicList = new DynamicList<>();
        for(int i = 0; i < 4; i++) {
            dynamicList.add("value" + i);
        }

        Iterator<String> it = dynamicList.iterator();

        int threads = 4;

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
                                it.next();
                                count++;
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

        assertFalse(it.hasNext());
    }
}
