package ru.tsibrovskii.Tree;

public class BinaryNode<E extends Comparable<E>> {

    private BinaryNode<E> leftChild;
    private BinaryNode<E> rightChild;
    private final E value;

    public BinaryNode(final E value) {
        this.value = value;
    }

    public void addLeft(BinaryNode<E> child) {
        this.leftChild = child;
    }

    public void addRight(BinaryNode<E> child) {
        this.rightChild = child;
    }

    public BinaryNode<E> getLeftChild() {
        return leftChild;
    }

    public BinaryNode<E> getRightChild() {
        return rightChild;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    public E getValue() {
        return this.value;
    }
}
