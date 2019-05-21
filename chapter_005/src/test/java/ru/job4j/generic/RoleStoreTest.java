package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code Role Store} container.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 21.05.2019
 */
public class RoleStoreTest {
    private RoleStore store = new RoleStore(20);

    @Before
    public void setUp() {
        store.add(new Role("admin", "Administrator"));
        store.add(new Role("junior", "Junior Java Developer"));
        store.add(new Role("middle", "Middle Java Developer"));
        store.add(new Role("senior", "Senior Java Developer"));
    }

    @Test
    public void whenAddRoleThenLengthGrowth() {
        assertThat(store.length(), is(4));
        store.add(new Role("lead", "TeamLead"));
        assertThat(store.length(), is(5));
    }

    @Test
    public void whenSearchRoleByCorrectIdThenFindIt() {
        assertThat(store.findById("admin").getJob(), is("Administrator"));
    }

    @Test
    public void whenSearchRoleByIncorrectIdThenReturnNull() {
        Role expected = null;
        assertThat(store.findById("incorrectID"), is(expected));
    }

    @Test
    public void whenReplaceRoleByCorrectIdThenReturnNewRole() {
        assertThat(store.replace("admin", new Role("scrum", "Scrum Master")), is(true));
        User expected = null;
        assertThat(store.findById("admin"), is(expected));
        assertThat(store.findById("scrum").getJob(), is("Scrum Master"));
    }

    @Test
    public void whenReplaceRoleByIncorrectIdThenReturnFalse() {
        assertThat(store.replace("incorrectID", new Role("newRole", "New Role")), is(false));
    }

    @Test
    public void whenDeleteRoleByCorrectIdThenReturnTrue() {
        assertThat(store.delete("junior"), is(true));
        User expected = null;
        assertThat(store.findById("junior"), is(expected));
    }

    @Test
    public void whenDeleteRoleByIncorrectIdThenReturnFalse() {
        assertThat(store.delete("incorrectID"), is(false));
    }
}