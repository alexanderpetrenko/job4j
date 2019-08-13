package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * {@code Simple Queue} creates a stack container of data.
 * Working principle: First Input, First Output (FIFO).
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 13.08.2019
 */
public class SimpleQueue<T> {
    private SimpleStack<T> straight = new SimpleStack<>();
    private SimpleStack<T> reverse = new SimpleStack<>();

    /**
     * Returns and removes the first element from this list.
     *
     * @return the first element from this list.
     * @throws NoSuchElementException if this list is empty.
     */
    public T poll() throws NoSuchElementException {
        if (reverse.size() == 0) {
            while (straight.size() != 0) {
                reverse.push(straight.poll());
            }
        }
        return reverse.poll();
    }

    /**
     * Inserts the specified element to the queue.
     *
     * @param value the element to add
     */
    public void push(T value) {
        straight.push(value);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list.
     */
    public int size() {
        return straight.size() + reverse.size();
    }
}
