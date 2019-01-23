package ru.job4j.loop;

/**
 * Object of the {@code Counter} class used to calculate
 * the sum of even numbers.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * The method calculates the sum of even numbers
     * in the range from {@code start} to {@code finish}.
     *
     * @param start Beginning of a range.
     * @param finish Ending of a range.
     * @return Sum of even numbers.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
