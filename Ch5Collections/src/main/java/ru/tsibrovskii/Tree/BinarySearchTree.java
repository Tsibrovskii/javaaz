package ru.tsibrovskii.Tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> implements SimpleBinaryTree<E> {

    private BinaryNode<E> root;
    private BinaryNode<E> tempElement;

    public BinarySearchTree(E root) {
        this.root = new BinaryNode<>(root);
        tempElement = this.root;
    }

    @Override
    public boolean add(E element) {
        boolean result = false;
        if(element.compareTo(tempElement.getValue()) > 0) {
            if(tempElement.getRightChild() == null) {
                tempElement.addRight(new BinaryNode<>(element));
                result = true;
            } else {
                tempElement = tempElement.getRightChild();
                result = add(element);
            }
        } else {
            if(tempElement.getLeftChild() == null) {
                tempElement.addLeft(new BinaryNode<>(element));
                result = true;
            } else {
                tempElement = tempElement.getLeftChild();
                result = add(element);
            }
        }
        tempElement = root;
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            boolean isRootAdded = false;
            Queue<BinaryNode<E>> data = new LinkedList<>();

            @Override
            public boolean hasNext() {
                return !data.isEmpty() || !isRootAdded;
            }

            @Override
            public E next() {
                BinaryNode<E> result;
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                if(!isRootAdded) {
                    data.offer(root);
                    isRootAdded = true;
                }
                result = data.poll();
                BinaryNode<E> tempBinaryNode = result.getLeftChild();
                if(tempBinaryNode != null) {
                    data.offer(tempBinaryNode);
                }
                tempBinaryNode = result.getRightChild();
                if(tempBinaryNode != null) {
                    data.offer(tempBinaryNode);
                }
                return result.getValue();
            }
        };
    }
}
