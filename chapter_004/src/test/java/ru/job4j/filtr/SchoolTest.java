package ru.job4j.filtr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void whenStudentsFilterToBestClass() {
        List<Student> students = new ArrayList<>(
                Arrays.asList(
                        new Student("Sologub", 0),
                        new Student("Ivanov", 30),
                        new Student("Petrov", 50),
                        new Student("Sidorov", 70),
                        new Student("Petrenko", 100)
                )
        );
        School school = new School();
        List<Student> result = school.collect(students,
                student -> student.getScore() > 0 && student.getScore() < 50);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student("Ivanov", 30));
        assertThat(result, is(expected));
    }

    @Test
    public void whenStudentsFilterToMiddleClass() {
        List<Student> students = new ArrayList<>(
                Arrays.asList(
                        new Student("Sologub", 0),
                        new Student("Ivanov", 30),
                        new Student("Petrov", 50),
                        new Student("Sidorov", 70),
                        new Student("Petrenko", 100)
                )
        );
        School school = new School();
        List<Student> result = school.collect(students,
                student -> student.getScore() >= 50 && student.getScore() < 70);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student("Petrov", 50));
        assertThat(result, is(expected));
    }

    @Test
    public void whenStudentsFilterToWorstClass() {
        List<Student> students = new ArrayList<>(
                Arrays.asList(
                        new Student("Sologub", 0),
                        new Student("Ivanov", 30),
                        new Student("Petrov", 50),
                        new Student("Sidorov", 70),
                        new Student("Petrenko", 100)
                )
        );
        School school = new School();
        List<Student> result = school.collect(students,
                student -> student.getScore() >= 70 && student.getScore() <= 100);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student("Sidorov", 70));
        expected.add(new Student("Petrenko", 100));
        assertThat(result, is(expected));
    }
}
