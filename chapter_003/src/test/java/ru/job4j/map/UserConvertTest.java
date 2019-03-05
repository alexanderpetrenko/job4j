package ru.job4j.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code UserConvert} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 04.03.2019
 */
public class UserConvertTest {
    /**
     * Test of List to Hash Map conversion.
     */
    @Test
    public void when3UsersListThen3UsersHashMap() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "James Bond", "London"));
        users.add(new User(2, "Gleb Zheglov", "Moscow"));
        users.add(new User(3, "Vladimir Sharapov", "Moscow"));
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, new User(1, "James Bond", "London"));
        expect.put(2, new User(2, "Gleb Zheglov", "Moscow"));
        expect.put(3, new User(3, "Vladimir Sharapov", "Moscow"));
        UserConvert converter = new UserConvert();
        assertThat(converter.process(users), is(expect));
    }
}
