package ru.job4j.filtr;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }

    public Map<String, Student> toMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        Student -> Student
                ));
    }
}
