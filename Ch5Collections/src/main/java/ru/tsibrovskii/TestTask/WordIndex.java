package ru.tsibrovskii.TestTask;

import org.apache.commons.collections4.Trie;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class WordIndex {

    private Map<Character, List<Integer>> indexMap = new HashMap<>();

    public void loadFile(String filename) throws IOException {
        String str;
        Integer position = -1;
        try (RandomAccessFile raf = new RandomAccessFile(filename, "r")) {
            while ((str = raf.readLine()) != null) {
                for (Character ch : str.toCharArray()) {
                    position++;
                    if(!indexMap.containsKey(ch)) {
                        indexMap.put(ch, new ArrayList<>());
                    }
                    indexMap.get(ch).add(position);
                }
            }
        }
    }

    public Set<Integer> getIndexes4Word(String searchWord) {
        Set<Integer> indexesSet = null;
        if(indexMap.keySet().contains(searchWord.charAt(0))) {
            indexesSet = new HashSet<>();
            for (Integer pos : indexMap.get(searchWord.charAt(0))) {
                Boolean isContains = true;
                Integer position = pos;
                for (Character ch : searchWord.substring(1).toCharArray()) {
                    if (!indexMap.get(ch).contains(++position)) {
                        isContains = false;
                        break;
                    }
                }
                if (isContains) {
                    indexesSet.add(pos);
                }
            }
        }
        return indexesSet;
    }
}
