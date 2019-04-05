package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * The {@code SortUser} class provides sort operation.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 19.03.2019
 */
public class SortUser {
    /**
     * The method converts List of Users to sorted Set.
     *
     * @param users List of Users.
     * @return Sorted TreeSet of Users.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    /**
     * The method sorts Users in the List by their name's length.
     *
     * @param users List of Users.
     * @return Sorted List.
     */
    public List<User> sortNameLength(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparingInt(o -> o.getName().length()))
                .collect(Collectors.toList());
    }

    /**
     * The method sorts the List of Users by their name and then by their age.
     *
     * @param users List of Users.
     * @return Sorted List.
     */
    public List<User> sortByAllFields(List<User> users) {
        return users.stream()
                .sorted((o1, o2) -> {
                    int rsl = o1.getName().compareTo(o2.getName());
                    return rsl != 0 ? rsl : Integer.compare(o1.getAge(), o2.getAge());
                })
                .collect(Collectors.toList());
    }

    public List<User> sortByNameThenAge(List<User> users) {
        return users.stream()
                .sorted(
                        Comparator.comparing(User::getName).thenComparing(User::getAge)
                ).collect(Collectors.toList());
    }
}
