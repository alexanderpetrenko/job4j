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
 * @since 16.04.2019
 */
public class ConvertMatrix2List {
    /**
     * The method provides converting operation from a two-dimensional array to a List.
     *
     * @param array Two-dimensional array of integer values.
     * @return List of Integer values.
     */
    public List<Integer> arrayToList(int[][] array) {
        return Arrays.stream(array)
                .flatMapToInt(Arrays::stream).boxed()
                .collect(Collectors.toList());
    }

    /**
     * The method provides converting operation from a matrix to a List.
     * Matrix consists of 2 nested lists of Integer values.
     *
     * @param matrix 2 nested lists of Integer values.
     * @return List of Integer values.
     */
    public List<Integer> matrixToList(List<List<Integer>> matrix) {
        return matrix.stream().flatMap(List::stream).collect(Collectors.toList());
    }
}
