package ru.job4j.array;

import java.util.Arrays;

/**
 * An object of the {@code ArrayDuplicates} class removes
 * duplicate elements in array.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
    /**
     * Drop duplicates.
     *
     * @param array input array.
     * @return array without duplicates.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int i = 0; i < unique; i++) {
            for (int j = i + 1; j < unique; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[unique - 1];
                    unique--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}