package ru.job4j.map;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The testing class for {@code Simple Hash Map} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 13.03.2020
 */
public class SimpleHashMapTest {
    @Test
    public void whenAdd2KeysWithDifferentHashThenAddAll() {
        User firstKey = new User("Petrenko", 0, new GregorianCalendar(1990, Calendar.FEBRUARY, 27));
        String firstValue = "First User";
        User secondKey = new User("Petrenko", 0, new GregorianCalendar(1990, Calendar.FEBRUARY, 27));
        String secondValue = "Second User";
        SimpleHashMap<User, String> map = new SimpleHashMap<>();
        map.insert(firstKey, firstValue);
        map.insert(secondKey, secondValue);
        assertThat(map.length(), is(2));
    }

    @Test
    public void whenAdd2KeysWithSameHashThenAddFirstOnly() {
        UserHashCode firstKey = new UserHashCode("Petrenko", 0, new GregorianCalendar(1990, Calendar.FEBRUARY, 27));
        String firstValue = "First User";
        UserHashCode secondKey = new UserHashCode("Petrenko", 0, new GregorianCalendar(1990, Calendar.FEBRUARY, 27));
        String secondValue = "Second User";
        SimpleHashMap<UserHashCode, String> map = new SimpleHashMap<>();
        assertThat(map.insert(firstKey, firstValue), is(true));
        assertThat(map.insert(secondKey, secondValue), is(false));
        assertThat(map.length(), is(1));
        assertThat(map.get(firstKey), is(firstValue));
        assertThat(map.get(secondKey), is(firstValue));
    }

    @Test
    public void whenAddNullKeyThenZeroIndex() {
        SimpleHashMap<Object, String> map = new SimpleHashMap<>();
        String value = "Value of null key";
        map.insert(null, value);
        assertThat(map.get(null), is(value));
    }

    @Test
    public void whenAddMoreElementsThenMapResize() {
        int startSize = 12;
        SimpleHashMap<String, String> map = new SimpleHashMap<>(startSize, 0.5f);
        for (int i = 0; i < 64; i++) {
            map.insert(Integer.toString(i), "User" + i);
        }
        assertThat(map.length(), greaterThan(startSize));
    }

    @Test
    public void whenDeleteElementThenZeroLength() {
        String key = "key";
        String value = "Test value";
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        assertThat(map.insert(key, value), is(true));
        assertThat(map.length(), is(1));
        assertThat(map.delete(key), is(true));
        assertThat(map.length(), is(0));
    }

    @Test
    public void whenDeleteNonexistentKeyThenFalse() {
        String key = "key";
        String value = "Test value";
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        assertThat(map.insert(key, value), is(true));
        assertThat(map.length(), is(1));
        assertThat(map.delete("nonexistent"), is(false));
        assertThat(map.length(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenAdd5ElementsThenGetThemByIterator() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        for (int i = 0; i < 5; i++) {
            map.insert(i, "User" + i);
        }
        Iterator<String> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        int i = 0;
        while (it.hasNext()) {
            assertThat(it.next(), is("User" + i++));
        }
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenUseIteratorAndAddElementThenException() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "User1");
        map.insert(5, "User5");
        Iterator<String> it = map.iterator();
        assertThat(it.next(), is("User1"));
        assertThat(it.next(), is("User5"));
        map.insert(3, "Exception");
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenUseIteratorAndDeleteElementThenException() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(2, "User2");
        map.insert(5, "User5");
        map.insert(15, "User15");
        Iterator<String> it = map.iterator();
        assertThat(it.next(), is("User2"));
        assertThat(map.delete(5), is(true));
        it.next();
    }
}