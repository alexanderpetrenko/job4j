package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code Simple Array} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 21.05.2019
 */
public class SimpleArrayTest {
    @Test
    public void whenCreateArrayOf4ElementsThen4() {
        SimpleArray<Integer> array = new SimpleArray<>(4);
        assertThat(array.length(), is(4));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddMoreElementsThenException() {
        SimpleArray<String> strings = new SimpleArray<>(1);
        strings.add("Hey");
        strings.add("User");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenSetElementOutOfArrayBoundsThenException() {
        SimpleArray<Double> doubles = new SimpleArray<>(2);
        doubles.add(3.1416);
        doubles.add(2.71828);
        doubles.set(123, 6.022);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenRemoveNotExistingElementThenException() {
        SimpleArray<Double> doubles = new SimpleArray<>(2);
        doubles.add(3.1416);
        doubles.add(2.71828);
        doubles.remove(123);
    }

    @Test
    public void whenArrayOfStringsThenReturnString() {
        SimpleArray<String> strings = new SimpleArray<>(5);
        strings.add("Hey");
        strings.add("User");
        strings.add("come");
        strings.add("on");
        strings.add("everybody");
        assertThat(strings.get(4), is("everybody"));
        strings.set(1, "Sasha");
        assertThat(strings.get(1), is("Sasha"));
    }

    @Test
    public void whenRemoveElementThenArrayBecomeShorter() {
        SimpleArray<String> strings = new SimpleArray<>(5);
        strings.add("Hey");
        strings.add("User");
        strings.add("come");
        strings.add("on");
        strings.add("everybody");
        assertThat(strings.length(), is(5));
        strings.remove(0);
        strings.remove(strings.length() - 1);
        assertThat(strings.length(), is(3));
        String[] expected = new String[]{"User", "come", "on"};
        Iterator<String> it = strings.iterator();
        int i = 0;
        while (it.hasNext()) {
            assertThat(it.next(), is(expected[i++]));
        }
    }
}