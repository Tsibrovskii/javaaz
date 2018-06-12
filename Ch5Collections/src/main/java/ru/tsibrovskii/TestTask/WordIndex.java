package ru.tsibrovskii.TestTask;

import org.apache.commons.collections4.Trie;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Set;

public class WordIndex {

    private TrieNode root = new TrieNode(null);

    public void loadFile(String filename) throws IOException {
        String str;
        Integer position = -1;
        TrieNode node = this.root;
        try (RandomAccessFile raf = new RandomAccessFile(filename, "r")) {
            while ((str = raf.readLine()) != null) {
                for (Character ch : str.toCharArray()) {
                    position++;
                    if (ch == ' ') {
                        node = this.root;
                        continue;
                    }
                    if (!node.getChildrenMap().keySet().contains(ch)) {
                        node.addChild(new TrieNode(ch));
                    }
                    node = node.getChildrenMap().get(ch);
                    node.addPosition(position);
                }
                position++;
                node = this.root;
            }
        }
    }

    public Set<Integer> getIndexes4Word(String searchWord) {
        Set<Integer> indexesSet = null;
        TrieNode node = this.root;
        for(Character ch : searchWord.toCharArray()) {
            if(node.getChildrenMap().containsKey(ch)) {
                node = node.getChildrenMap().get(ch);
            } else {
                node = null;
                break;
            }
        }
        if(node != null) {
            indexesSet = new HashSet<>();
            for(Integer pos : node.getPositions()) {
                indexesSet.add(pos + 1 - searchWord.length());
            }
        }
        return indexesSet;
    }
}
