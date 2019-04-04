package ru.job4j.list;

import java.util.ArrayList;
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
        int cells = list.size() / rows + (list.size() % rows == 0 ? 0 : 1);
        int[][] array = new int[rows][cells];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
//                array[i][j] = list.stream().forEach();
            }
        }
//        for (Integer integer : list) {
//            array[i][j++] = integer;
//            if (j == cells) {
//                i++;
//                j = 0;
//            }
//        }
        return array;
    }

    /**
     * The method converts List of arrays to the one Integer List.
     *
     * @param list Source List.
     * @return One-dimensional List, that was obtained from two-dimensional.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
//        Iterator<int[]> it = list.iterator();
//        while (it.hasNext()) {
//            for (int number : it.next()) {
//                result.add(number);
//            }
//        }
        return result;
    }
}
