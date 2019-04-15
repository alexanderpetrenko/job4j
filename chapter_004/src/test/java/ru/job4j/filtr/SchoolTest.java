package ru.job4j.filtr;

import org.junit.Test;

import java.util.*;

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

    @Test
    public void whenStudentsCollectToMap() {
        List<Student> students = new ArrayList<>(
                Arrays.asList(
                        new Student("Ivanov", 30),
                        new Student("Petrov", 50),
                        new Student("Sidorov", 70)
                )
        );
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivanov", new Student("Ivanov", 30));
        expected.put("Petrov", new Student("Petrov", 50));
        expected.put("Sidorov", new Student("Sidorov", 70));
        assertThat(new School().toMap(students), is(expected));
    }
}
