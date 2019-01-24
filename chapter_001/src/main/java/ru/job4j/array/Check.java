package ru.job4j.array;

/**
 * An object of the {@code Check} class is used for
 * check the combination of array elements.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Check {
    /**
     * This method checks if all array elements
     * are the same.
     *
     * @param data Data array with boolean elements.
     * @return Result is {@code true},
     * if all elements in an array are the same.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 1; i <= data.length - 1; i++) {
            if (data[i - 1] != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
