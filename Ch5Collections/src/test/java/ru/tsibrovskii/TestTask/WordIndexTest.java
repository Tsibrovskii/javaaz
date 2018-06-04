package ru.tsibrovskii.TestTask;

import org.junit.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class WordIndexTest {

    @Test
    public void whenTakeWordShouldReturnPositions() throws IOException {
        WordIndex wordIndex = new WordIndex();
        wordIndex.loadFile("./index.txt");
        Set<Integer> result = wordIndex.getIndexes4Word("Goo");
        assertTrue(result.size() == 2);
        assertTrue(result.contains(0));
        assertTrue(result.contains(39));
    }
}
