package ru.tsibrovskii.Tree;

import java.util.*;

/**
 * Класс дерева.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    public Node<E> root;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = true;
        Optional<Node<E>> parentNode = findBy(parent);
        if(parentNode.isPresent()) {
            for (Node<E> childNode : parentNode.get().leaves()) {
                if (childNode.eqValue(child)) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        if(result) {
            parentNode.get().add(new Node<>(child));
        }
        return result;
    }

    @Override
    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if(el.leaves().size() <= 2) {
                for (Node<E> child : el.leaves()) {
                    data.offer(child);
                }
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            boolean isRootAdded = false;
            Queue<Node<E>> data = new LinkedList<>();

            @Override
            public boolean hasNext() {
                return !data.isEmpty() || !isRootAdded;
            }

            @Override
            public E next() {
                Node<E> result;
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                if(!isRootAdded) {
                    data.offer(root);
                    isRootAdded = true;
                }
                result = data.poll();
                for (Node<E> child : result.leaves()) {
                    data.offer(child);
                }
                return result.getValue();
            }
        };
    }
}
