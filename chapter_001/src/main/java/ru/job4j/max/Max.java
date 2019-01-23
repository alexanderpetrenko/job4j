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
     * This method determines the maximum of two numbers.
     *
     * @param first  First number.
     * @param second Second number.
     * @return Maximum number
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * This method determines the maximum of three numbers.
     * @param first  First number.
     * @param second Second number.
     * @param third Third number.
     * @return Maximum number.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}