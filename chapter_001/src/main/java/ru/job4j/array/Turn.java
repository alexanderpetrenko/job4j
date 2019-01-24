package ru.job4j.array;

/**
 * An object of the {@code Turn} class is used for
 * turning the order of elements in an array.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    /**
     * Method for turning elements order in reverse direction.
     *
     * @param array Array of integer numbers.
     * @return The same array of integer numbers
     * in reverse direction order.
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}
