package ru.job4j.map;

import org.junit.Test;

import java.util.List;
import java.util.Map;

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
        List<User> users = List.of(
                new User(1, "James Bond", "London"),
                new User(2, "Gleb Zheglov", "Moscow"),
                new User(3, "Vladimir Sharapov", "Moscow")
        );
        Map<Integer, User> expect = Map.of(
                1, new User(1, "James Bond", "London"),
                2, new User(2, "Gleb Zheglov", "Moscow"),
                3, new User(3, "Vladimir Sharapov", "Moscow")
        );
        UserConvert converter = new UserConvert();
        assertThat(converter.process(users), is(expect));
    }
}
