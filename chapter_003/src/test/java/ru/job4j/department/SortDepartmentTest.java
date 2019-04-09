package ru.job4j.department;

import org.junit.Test;

import java.util.*;

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
        assertThat(departments.sortAsc(Arrays.asList(codes)), is(new TreeSet<String>(Arrays.asList(expected))));
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
        assertThat(departments.sortDesc(Arrays.asList(codes)), is(new TreeSet<String>(Arrays.asList(expected))));
    }

    /**
     * Test for Adding absent senior Department's Names from String
     * of junior Department's Name.
     */
    @Test
    public void whenDepsNameThenAddAbsentDepsToList() {
        SortDepartment departments = new SortDepartment();
        String input = "k1\\sk1\\ssk1";
        List<String> expected = new LinkedList<>();
        expected.add("k1");
        expected.add("k1\\sk1");
        expected.add("k1\\sk1\\ssk1");
        assertThat(departments.addAbsent(input), is(expected));
    }
}
