package ru.job4j.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code Simple Queue} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 13.08.2019
 */
public class SimpleQueueTest {
    @Test
    public void whenAddElementsThenLengthGrows() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        assertThat(queue.size(), is(0));
        queue.push(101);
        assertThat(queue.size(), is(1));
        queue.push(102);
        assertThat(queue.size(), is(2));
        queue.push(103);
        assertThat(queue.size(), is(3));
    }

    @Test
    public void whenFirstInputThenFirstOutput() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.size(), is(3));
        assertThat(queue.poll(), is(1));
        assertThat(queue.size(), is(2));
        assertThat(queue.poll(), is(2));
        assertThat(queue.size(), is(1));
        assertThat(queue.poll(), is(3));
        assertThat(queue.size(), is(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenPollEmptyStackThenException() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.poll();
    }
}