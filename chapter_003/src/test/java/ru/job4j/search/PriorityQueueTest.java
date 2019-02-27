package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code PriorityQueue} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class PriorityQueueTest {
    /**
     * Linked List Test using loop For
     */
    @Test
    public void whenHigherQueueTestPutFor() {
        PriorityQueue queue = new PriorityQueue();
        queue.putFor(new Task("low", 5));
        queue.putFor(new Task("urgent", 1));
        queue.putFor(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDescription(), is("urgent"));
    }

    /**
     * Linked List Test using loop Foreach
     */
    @Test
    public void whenHigherQueueTestPutForeach() {
        PriorityQueue queue = new PriorityQueue();
        queue.putForeach(new Task("low", 5));
        queue.putForeach(new Task("urgent", 1));
        queue.putForeach(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDescription(), is("urgent"));
    }

    /**
     * Linked List Test using loop Iterator
     */
    @Test
    public void whenHigherQueueTestPutIterator() {
        PriorityQueue queue = new PriorityQueue();
        queue.putIterator(new Task("low", 5));
        queue.putIterator(new Task("urgent", 1));
        queue.putIterator(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDescription(), is("urgent"));
    }
}
