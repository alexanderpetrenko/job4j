package ru.job4j.array;

/**
 * An object of the {@code FindLoop} class is used for
 * search a required number in an array.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {
    /**
     * This method searches a required element in an array.
     *
     * @param data Initial data array.
     * @param el   Required element of array.
     * @return Index of required element.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int i = 0; i <= data.length - 1; i++) {
            if (el == data[i]) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}
