package ru.job4j.loop;

/**
 * The object of {@code Factorial} class used for
 * calculation the factorial operation.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * The method encounters factorial operation (n!).
     *
     * @param n Positive integer number.
     * @return Result of the factorial operation.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
