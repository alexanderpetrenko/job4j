package ru.job4j.department;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortDepartmentTest {
    @Test
    public void whenArrayOfCodesThenSortedSetDeps() {
        String[] codes = new String[] {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        Set<Department> expected = new TreeSet<>();
        for (String code : codes) {
            expected.add(new Department(code));
        }
        expected.add(new Department("K2"));
        SortDepartment departments = new SortDepartment();
        assertThat(departments.sortAscending(codes), is(expected));
    }
}
