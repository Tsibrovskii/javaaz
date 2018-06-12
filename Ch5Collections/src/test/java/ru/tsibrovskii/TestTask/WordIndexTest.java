package ru.tsibrovskii.TestTask;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordIndexTest {

    @Test
    public void whenTakeWordShouldReturnPositions() throws IOException {
        WordIndex wordIndex = new WordIndex();
        wordIndex.loadFile("./index.txt");
        List<Integer> result = new ArrayList<>(wordIndex.getIndexes4Word("Goo"));
        assertThat(result.size(), is(2));
        assertThat(result.get(0), is(0));
        assertThat(result.get(1), is(43));
    }
}
