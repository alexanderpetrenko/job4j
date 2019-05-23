package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * {@code Simple Stack} creates a stack container of data.
 * Working principle: Last Input, First Output (LIFO).
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 23.05.2019
 */
public class SimpleStack<T> {
    private SimpleArrayList<T> data = new SimpleArrayList<>();

    /**
     * Returns and removes the first element from this list.
     *
     * @return the first element from this list.
     * @throws NoSuchElementException if this list is empty.
     */
    public T poll() throws NoSuchElementException {
        return (T) this.data.delete();
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param value the element to add
     */
    public void push(T value) {
        this.data.add(value);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list.
     */
    public int size() {
        return this.data.getSize();
    }
}
