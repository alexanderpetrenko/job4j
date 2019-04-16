package ru.job4j.filtr;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The {@code School} class collects students to List and to Map.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 16.04.2019
 */
public class School {
    /**
     * The method collects students to class using their score.
     *
     * @param students  List of students.
     * @param predicate Condition for collection.
     * @return Collection of students.
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * The method collects students to map.
     * Key is student's name, and Value is Object of Student.
     *
     * @param students List of students.
     * @return Map of students.
     */
    public Map<String, Student> toMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        Student -> Student
                ));
    }
}
