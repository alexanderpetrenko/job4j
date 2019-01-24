package ru.job4j.array;

/**
 * An object of the {@code BubbleSort} class is used
 * for sorting elements in an array.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     * Bubble sort of an array.
     *
     * @param array Input data array.
     * @return Sorted array from minimum to maximum value.
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
