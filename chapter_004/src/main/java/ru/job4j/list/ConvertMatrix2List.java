package ru.job4j.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code ConvertMatrix2List} class provides converting operation
 * from a two-dimensional array to a List.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 09.04.2019
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        return Arrays.stream(array)
                .flatMapToInt(Arrays::stream).boxed()
                .collect(Collectors.toList());
    }
}
