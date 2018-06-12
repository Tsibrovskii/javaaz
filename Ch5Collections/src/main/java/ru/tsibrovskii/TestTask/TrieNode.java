package ru.tsibrovskii.TestTask;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TrieNode {

    private final Character node;
    private Set<Integer> positionsSet;
    private Map<Character, TrieNode> childrenMap;

    public TrieNode(Character node) {
        this.node = node;
        this.childrenMap = new HashMap<>();
        this.positionsSet = new HashSet<>();
    }

    public Character getName() {
        return this.node;
    }

    public void addPosition(Integer position) {
        positionsSet.add(position);
    }

    public Set<Integer> getPositions() {
       return this.positionsSet;
    }

    public void addChild(TrieNode child) {
        childrenMap.put(child.getName(), child);
    }

    public Map<Character, TrieNode> getChildrenMap() {
        return this.childrenMap;
    }


}
