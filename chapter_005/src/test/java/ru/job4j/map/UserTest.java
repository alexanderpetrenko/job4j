package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The {@code Hash Map} Testing class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 29.08.2019
 */
public class UserTest {
    @Test
    public void whenHashCodeAndEqualsNotOverrideThen2DifferentUsersAddToMap() {
        User first = new User("Petrenko", 0, new GregorianCalendar(1990, Calendar.FEBRUARY, 27));
        User second = new User("Petrenko", 0, new GregorianCalendar(1990, Calendar.FEBRUARY, 27));
        Map<User, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
        assertThat(map.size(), is(2));
    }

    @Test
    public void whenHashCodeOverrideThen2UsersWithSameHashCodeAddToMap() {
        UserHashCode first = new UserHashCode("Petrenko", 0, new GregorianCalendar(1990, Calendar.FEBRUARY, 27));
        UserHashCode second = new UserHashCode("Petrenko", 0, new GregorianCalendar(1990, Calendar.FEBRUARY, 27));
        Map<UserHashCode, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
        assertThat(map.size(), is(2));
    }

    @Test
    public void whenEqualsHashCodeOverrideThen1UsersAddToMap() {
        UserEqualsHash first = new UserEqualsHash("Petrenko", 0, new GregorianCalendar(1990, Calendar.FEBRUARY, 27));
        UserEqualsHash second = new UserEqualsHash("Petrenko", 0, new GregorianCalendar(1990, Calendar.FEBRUARY, 27));
        Map<UserEqualsHash, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
        assertThat(map.size(), is(1));
    }
}