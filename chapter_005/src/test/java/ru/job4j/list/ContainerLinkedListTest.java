package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code Container Linked List} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 22.05.2019
 */
public class ContainerLinkedListTest {
    private ContainerLinkedList<Integer> list = new ContainerLinkedList<>();

    @Before
    public void setUp() {
        for (int i = 1; i <= 5; i++) {
            this.list.add(i);
        }
    }

    @Test
    public void whenAdd5ElementsThenUseGet1Result2() {
        assertThat(this.list.get(0), is(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenAdd5ElementsThenGetThemByIterator() {
        Iterator<Integer> it = this.list.iterator();
        assertThat(it.hasNext(), is(true));
        int i = this.list.length();
        while (it.hasNext()) {
            assertThat(it.next(), is(i--));
        }
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void whenAddSixthElementThenArrayDynamicallyGrows() {
        assertThat(this.list.length(), is(5));
        this.list.add(6);
        assertThat(this.list.length(), is(6));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenUseIteratorAndModifyArrayThenException() {
        Iterator<Integer> it = this.list.iterator();
        assertThat(it.next(), is(this.list.get(0)));
        this.list.add(123);
        it.next();
    }
}