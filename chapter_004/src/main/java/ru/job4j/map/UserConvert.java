package ru.job4j.map;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code UserConvert} class provides converting operation
 * from a List to a Hash Map.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 04.03.2019
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        return (HashMap<Integer, User>) list.stream()
                .distinct()
                .collect(Collectors.toMap(User::getId, u -> u));
    }
}
