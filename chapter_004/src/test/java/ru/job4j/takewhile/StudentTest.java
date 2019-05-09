package ru.job4j.takewhile;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code Student} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 09.05.2019
 */
public class StudentTest {
    /**
     * Test for sorting operation of Students by their Boundary Score.
     */
    @Test
    public void whenListStudentsThenSortedList() {
        Student student1 = new Student("Bob", 91);
        Student student2 = new Student("Alina", 91);
        Student student3 = new Student("Mark", 93);
        Student student4 = new Student("Anfisa");
        Student student5 = new Student("Paul", 30);
        Student student6 = new Student("Bond", 90);
        List<Student> students = Arrays.asList(
                null,
                student1,
                student2,
                null,
                student3,
                null,
                student4,
                student5,
                null,
                student6, null
        );
        List<Student> expected = List.of(student3, student2, student1);
        assertThat(Student.levelOf(students, 90), is(expected));
    }
}
