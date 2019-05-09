package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code SortUser} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 09.04.2019
 */
public class SortUserTest {
    /**
     * Test for sorting operation of Users by their age and name.
     */
    @Test
    public void whenListThenSortedTreeSet() {
        List<User> users = List.of(
                new User("stark", 35),
                new User("willis", 64),
                new User("bond", 50),
                new User("stark", 60)
        );
        Set<User> expected = Set.of(
                new User("stark", 35),
                new User("stark", 60),
                new User("bond", 50),
                new User("willis", 64)
        );
        SortUser sorting = new SortUser();
        Set<User> result = sorting.sort(users);
        assertThat(result, is(expected));
    }

    /**
     * Test for sorting operation of Users by the Length of their Name.
     */
    @Test
    public void whenListThenSortByNameLength() {
        List<User> users = List.of(
                new User("stark", 35),
                new User("willis", 64),
                new User("bond", 50),
                new User("CJ", 60)
        );
        List<User> expected = List.of(
                new User("CJ", 60),
                new User("bond", 50),
                new User("stark", 35),
                new User("willis", 64)
        );
        SortUser sorting = new SortUser();
        List<User> result = sorting.sortNameLength(users);
        assertThat(result, is(expected));
    }

    /**
     * Test for sorting operation of Users by their Names and then by their age.
     */
    @Test
    public void whenListThenSortByAllFields() {
        List<User> users = List.of(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
        );
        List<User> expected = List.of(
                new User("Иван", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Сергей", 25)
        );
        SortUser sorting = new SortUser();
        List<User> result = sorting.sortByAllFields(users);
        assertThat(result, is(expected));
    }

    @Test
    public void whenListThenSortByNameAge() {
        List<User> users = List.of(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
        );
        List<User> expected = List.of(
                new User("Иван", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Сергей", 25)
        );
        SortUser sorting = new SortUser();
        List<User> result = sorting.sortByNameThenAge(users);
        assertThat(result, is(expected));
    }
}
