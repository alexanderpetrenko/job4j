package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * {@code Simple Array List} creates a linked list of data.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 22.05.2019
 */
public class SimpleArrayList<E> {
    /**
     * Quantity of all elements in the list.
     */
    private int size;
    /**
     * Link to the first element of the list.
     */
    private Node<E> first;

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param data the element to add
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list.
     * @throws NoSuchElementException if this list is empty.
     */
    public E delete() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("The Array List is empty");
        }
        Node<E> deletedNode = this.first;
        this.first = deletedNode.next;
        deletedNode.next = null;
        this.size--;
        return deletedNode.data;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return.
     * @return the element at the specified position in this list.
     * @throws IndexOutOfBoundsException if index is out of list bounds.
     */
    public E get(int index) throws NoSuchElementException {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Requested array's element does not exist");
        }
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list.
     */
    public int getSize() {
        return this.size;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
