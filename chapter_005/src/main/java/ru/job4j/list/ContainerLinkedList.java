package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * {@code Container Linked List} class creates a linked list of data.
 *
 * @param <E> A reference type of array elements.
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 22.05.2019
 */
public class ContainerLinkedList<E> implements SimpleContainer<E> {
    /**
     * Quantity of all elements in the list.
     */
    private int size;
    /**
     * Link to the first element of the list.
     */
    private Node<E> first;
    /**
     * Modification counter.
     */
    private int modCount;

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int length() {
        return this.size;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param value the element to add
     */
    @Override
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        this.modCount++;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return.
     * @return the element at the specified position in this list.
     * @throws IndexOutOfBoundsException if index is out of list bounds.
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
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
     * Returns an iterator over the elements in this list in proper sequence.
     * The returned iterator is fail-fast.
     *
     * @return an iterator object.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = ContainerLinkedList.this.modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < ContainerLinkedList.this.size;
            }

            @Override
            public E next() throws NoSuchElementException, ConcurrentModificationException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.expectedModCount != ContainerLinkedList.this.modCount) {
                    throw new ConcurrentModificationException();
                }
                return ContainerLinkedList.this.get(this.index++);
            }
        };
    }

    /**
     * Inner static class {@code Node} provides saving data.
     *
     * @param <E> A reference type of data value.
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
