package ru.job4j.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code Simple Stack} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 23.05.2019
 */
public class SimpleStackTest {
    @Test
    public void whenAddElementsThenLengthGrows() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        assertThat(stack.size(), is(0));
        stack.push(101);
        assertThat(stack.size(), is(1));
        stack.push(102);
        assertThat(stack.size(), is(2));
        stack.push(103);
        assertThat(stack.size(), is(3));
    }

    @Test
    public void whenLastInputThenFirstOutput() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.size(), is(3));
        assertThat(stack.poll(), is(3));
        assertThat(stack.size(), is(2));
        assertThat(stack.poll(), is(2));
        assertThat(stack.size(), is(1));
        assertThat(stack.poll(), is(1));
        assertThat(stack.size(), is(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenPollEmptyStackThenException() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.poll();
    }
}