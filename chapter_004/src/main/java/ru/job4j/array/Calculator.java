package ru.job4j.array;

/**
 * The {@code Calculator} class provides mathematical operations.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 10.05.2019
 */
public class Calculator {
    /**
     * The method calculates a sum of diagonal elements from a square array.
     *
     * @param array Input array.
     * @return The sum of diagonal elements.
     */
    public int sumDiagonals(int[][] array) {
        int result = 0;
        for (int i = 0; i != array.length; i++) {
            result += array[i][i] + array[array.length - 1 - i][i];
        }
        return result;
    }
}
