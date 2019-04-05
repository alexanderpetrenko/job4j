package ru.job4j.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code ConvertList2Array} class provides converting operation
 * of integer numbers from a List to an Array.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows + (list.size() % rows == 0 ? 0 : 1);
        int[][] array = new int[rows][cells];
        final int[] row = {0};
        final int[] cell = {0};
        list.forEach(x -> {
            array[row[0]][cell[0]++] = x;
            if (cell[0] == cells) {
                cell[0] = 0;
                row[0]++;
            }
        });
        return array;
    }

    /**
     * The method converts List of arrays to the one Integer List.
     *
     * @param list Source List.
     * @return One-dimensional List, that was obtained from two-dimensional.
     */
    public List<Integer> convert(List<int[]> list) {
        return list.stream().flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
    }
}
