package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code Simple Array List} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 22.05.2019
 */
public class SimpleArrayListTest {
    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetElementByIncorrectIndexThenException() {
        list.get(100);
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteFirstElementThenUseGetOneResultOne() {
        var deleted = list.get(0);
        var nextFirst = list.get(1);
        assertThat(list.delete(), is(deleted));
        assertThat(list.get(0), is(nextFirst));
        assertThat(list.getSize(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFromEmptyArrayListThenException() {
        SimpleArrayList<String> empty = new SimpleArrayList<>();
        empty.delete();
    }
}