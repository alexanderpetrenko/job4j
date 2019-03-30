package ru.job4j.department;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code SortDepartment} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 30.03.2019
 */
public class SortDepartmentTest {
    /**
     * Test for sorting ascending departments.
     */
    @Test
    public void whenDepsSortAscending() {
        String[] codes = new String[]{
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        String[] expected = new String[]{
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        SortDepartment departments = new SortDepartment();
        assertThat(departments.sortAscending(codes), is(expected));
    }

    /**
     * Test for sorting descending departments.
     */
    @Test
    public void whenDepsSortDescending() {
        String[] codes = new String[]{
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        String[] expected = new String[]{
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        SortDepartment departments = new SortDepartment();
        assertThat(departments.sortDescending(codes), is(expected));
    }
}
