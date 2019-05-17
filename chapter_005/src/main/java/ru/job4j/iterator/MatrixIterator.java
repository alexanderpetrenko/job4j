package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * {@code Matrix Iterator} returns the next element of the matrix.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 16.05.2019
 */
public class MatrixIterator implements Iterator {
    private final int[][] values;
    private int i = 0;
    private int j = 0;

    public MatrixIterator(int[][] array) {
        this.values = array;
    }

    @Override
    public boolean hasNext() {
        return i < values.length && j < values[i].length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("There are no further elements");
        }
        int result = values[i][j];
        if (j < values[i].length - 1) {
            j++;
        } else {
            i++;
            j = 0;
        }
        return result;
    }
}