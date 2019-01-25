package ru.job4j.array;

/**
 * An object of the {@code MatrixCheck} class is used for
 * checking the combination of array elements int the diagonals.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    /**
     * This method checks if all diagonal elements
     * of the input matrix are the same.
     *
     * @param data Input square matrix
     * @return Result is {@code true},
     * if all elements in the diagonals are the same;
     * otherwise {@code false}.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1][i - 1] != data[i][i] || data[i - 1][data.length - i] != data[i][data.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
