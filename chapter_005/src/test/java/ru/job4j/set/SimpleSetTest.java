package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code Simple Set} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 27.08.2019
 */
public class SimpleSetTest {
    private SimpleSet<Integer> set = new SimpleSet<>();

    @Before
    public void setUp() {
        for (int i = 1; i <= 5; i++) {
            set.add(i);
        }
    }

    @Test
    public void whenAdd5ElementThenGetThemByIterator() {
        Iterator it = set.iterator();
        int i = 1;
        while (it.hasNext()) {
            assertThat(it.next(), is(i++));
        }
    }

    @Test
    public void whenAddExistingElementsThenAddingIgnored() {
        set.add(2);
        set.add(4);
        set.add(5);
        Iterator it = set.iterator();
        int i = 1;
        while (it.hasNext()) {
            assertThat(it.next(), is(i++));
        }
    }

    @Test
    public void whenAddUniqueElementsThenAddingApproved() {
        set.add(6);
        set.add(7);
        Iterator it = set.iterator();
        int i = 1;
        while (it.hasNext()) {
            assertThat(it.next(), is(i++));
        }
    }
}