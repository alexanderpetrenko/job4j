package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    @Test
    public void whenCreateArrayOf4ElementsThen4() {
        SimpleArray<Integer> array = new SimpleArray<>(4);
        assertThat(array.length(), is(4));
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddMoreElementsThenException() {
        SimpleArray<String> strings = new SimpleArray<>(1);
        strings.add("Hey");
        strings.add("User");
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
    public void whenRemoveElementThenLengthShorter() {
        SimpleArray<String> strings = new SimpleArray<>(5);
        strings.add("Hey");
        strings.add("User");
        strings.add("come");
        strings.add("on");
        strings.add("everybody");
        assertThat(strings.length(), is(5));
        strings.remove(1);
        for (String s : strings) {
            System.out.println(s);
        }
        assertThat(strings.length(), is(4));

    }
}