package ru.job4j.array;

/**
 * An object of the {@code BubbleSort} class is used
 * for merging two arrays in a resulting array.
 * Resulting array is sorted by ascending.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class ExamTask {
    /**
     * This method uses merge sort algorithm.
     *
     * @param first  integer array.
     * @param second integer array.
     * @return Resulting integer array, sorted by ascending.
     */
    public int[] merge(int[] first, int[] second) {
        int size = first.length + second.length;
        int[] result = new int[size];
        int i = 0;
        int j = 0;
        for (int k = 0; k < size; k++) {
            if (i >= first.length) {
                result[k] = second[j];
                j++;
            } else if (j >= second.length) {
                result[k] = first[i];
                i++;
            } else if (second[j] < first[i]) {
                result[k] = second[j];
                j++;
            } else {
                result[k] = first[i];
                i++;
            }
        }
        return result;
    }
}
