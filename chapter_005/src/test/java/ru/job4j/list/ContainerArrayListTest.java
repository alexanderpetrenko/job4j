package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code Container Array List} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 22.05.2019
 */
public class ContainerArrayListTest {
    private ContainerArrayList<Integer> list = new ContainerArrayList<>();

    @Before
    public void setUp() {
        for (int i = 1; i <= 5; i++) {
            this.list.add(i);
        }
    }

    @Test
    public void whenAdd5ElementsThenUseGet1Result2() {
        assertThat(this.list.get(1), is(2));
    }

    @Test
    public void whenAdd5ElementsThenGetThemByIterator() {
        Iterator<Integer> it = this.list.iterator();
        int i = 1;
        while (it.hasNext()) {
            assertThat(it.next(), is(i++));
        }
    }

    @Test
    public void whenAddSixthElementThenArrayDynamicallyGrows() {
        assertThat(this.list.length(), is(5));
        this.list.add(6);
        assertThat(this.list.length(), is(6));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenUseIteratorAndModifyArrayThenException() {
        Iterator<Integer> it = this.list.iterator();
        assertThat(it.next(), is(this.list.get(0)));
        this.list.add(123);
        it.next();
    }
}