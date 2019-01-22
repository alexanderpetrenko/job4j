package ru.job4j.max;

/**
 * Determine the maximum of two numbers.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {

    /**
     * This method determines the maximum.
     *
     * @param first  First number.
     * @param second Second number.
     * @return Maximum number
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}