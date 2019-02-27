package ru.job4j.list;

import java.util.List;

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
        int cells = list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (Integer integer : list) {
            array[i][j++] = integer;
            if (j == cells) {
                i++;
                j = 0;
            }
        }
        return array;
    }
}
