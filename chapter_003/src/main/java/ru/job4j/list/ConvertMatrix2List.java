package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ConvertMatrix2List} class provides converting operation
 * from a two-dimensional array to a List.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }
}
