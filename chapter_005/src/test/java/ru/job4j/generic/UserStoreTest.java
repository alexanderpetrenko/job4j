package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code User Store} container.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 21.05.2019
 */
public class UserStoreTest {
    private UserStore store = new UserStore(20);

    @Before
    public void setUp() {
        store.add(new User("user1", "James Bond"));
        store.add(new User("user2", "Will Smith"));
        store.add(new User("user3", "Iron Man"));
        store.add(new User("user4", "Rocky Balboa"));
    }

    @Test
    public void whenAddUserThenLengthGrowth() {
        assertThat(store.length(), is(4));
        store.add(new User("user5", "Robin Hood"));
        assertThat(store.length(), is(5));
    }

    @Test
    public void whenSearchUserByCorrectIdThenFindHim() {
        assertThat(store.findById("user1").getName(), is("James Bond"));
    }

    @Test
    public void whenSearchUserByIncorrectIdThenReturnNull() {
        User expected = null;
        assertThat(store.findById("incorrectID"), is(expected));
    }

    @Test
    public void whenReplaceUserByCorrectIdThenReturnNewUser() {
        assertThat(store.replace("user1", new User("replaced", "New User")), is(true));
        User expected = null;
        assertThat(store.findById("user1"), is(expected));
        assertThat(store.findById("replaced").getName(), is("New User"));
    }

    @Test
    public void whenReplaceUserByIncorrectIdThenReturnFalse() {
        assertThat(store.replace("incorrectID", new User("newUser", "New User")), is(false));
    }

    @Test
    public void whenDeleteUserByCorrectIdThenReturnTrue() {
        assertThat(store.delete("user3"), is(true));
        User expected = null;
        assertThat(store.findById("user3"), is(expected));
    }

    @Test
    public void whenDeleteUserByIncorrectIdThenReturnFalse() {
        assertThat(store.delete("incorrectID"), is(false));
    }
}