package ru.job4j.array;

/**
 * An object of the {@code Square} class calculates
 * squared value numbers.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Square {
    /**
     * This method calculates squared value of numbers in a range
     * from {@code 1} to {@code bound} and writes them to an array.
     *
     * @param bound Array boundary.
     * @return An array of squares.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}
