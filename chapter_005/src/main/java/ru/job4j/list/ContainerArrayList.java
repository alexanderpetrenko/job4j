package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * {@code Simple Array List} creates a dynamic array of data.
 *
 * @param <E> A reference type of array elements.
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 22.05.2019
 */
public class ContainerArrayList<E> implements SimpleContainer<E> {
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_SIZE = 5;
    /**
     * Data array.
     */
    private Object[] container;
    /**
     * Position for the next element.
     */
    private int position = 0;
    /**
     * Modification counter.
     */
    private int modCount;

    /**
     * Constructs an empty list with an initial capacity of five.
     */
    public ContainerArrayList() {
        this(DEFAULT_SIZE);
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param size the initial capacity of the list.
     */
    public ContainerArrayList(int size) {
        container = new Object[size];
        this.modCount = 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list.
     */
    public int length() {
        return this.position;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param value element to be appended to this list.
     */
    @Override
    public void add(E value) {
        if (this.position == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[position++] = value;
        this.modCount++;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return.
     * @return the element at the specified position in this list.
     * @throws IndexOutOfBoundsException when input index of element
     *                                   is out of array's bounds.
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index >= position || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of array's bounds");
        }
        return (E) container[index];
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
            private final int expectedModCount = ContainerArrayList.this.modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < ContainerArrayList.this.position;
            }

            @Override
            public E next() throws NoSuchElementException, ConcurrentModificationException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.expectedModCount != ContainerArrayList.this.modCount) {
                    throw new ConcurrentModificationException();
                }
                return (E) container[index++];
            }
        };
    }
}
