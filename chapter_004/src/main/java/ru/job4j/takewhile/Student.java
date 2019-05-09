package ru.job4j.takewhile;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The {@code Student} class saves an information about student.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 09.05.2019
 */
public class Student implements Comparator<Student> {
    private String name;
    private int scope;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    /**
     * The method provides sort operation.
     *
     * @param students List of Students.
     * @param bound    Boundary Score.
     * @return Sorted List of Students.
     */
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted(new Student())
                .takeWhile(student -> student.getScope() > bound)
                .collect(Collectors.toList());
    }

    @Override
    public int compare(Student st1, Student st2) {
        int k = Integer.compare(st2.getScope(), st1.getScope());
        return k != 0 ? k : st1.getName().compareTo(st2.getName());
    }
}
