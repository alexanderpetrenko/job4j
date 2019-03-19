package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
}
