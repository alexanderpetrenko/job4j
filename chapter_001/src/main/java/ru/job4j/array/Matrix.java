package ru.job4j.array;

/**
 * An object of the {@code Matrix} class is used
 * for creating multiplication table.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Matrix {
    /**
     * Method calculates values of multiplication table.
     *
     * @param size Size of matrix
     * @return Two-dimensional array, which elements are values
     * of multiplication table.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }
        return table;
    }
}
