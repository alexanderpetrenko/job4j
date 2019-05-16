package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * {@code Matrix Iterator} returns the next element of the matrix.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 16.05.2019
 */
public class MatrixIterator implements Iterator {
    private final int[][] values;
    private int size;
    private int i = 0;
    private int j = 0;
    private int count = 0;

    public MatrixIterator(int[][] array) {
        this.values = array;
        this.size = (int) Arrays.stream(array).flatMapToInt(Arrays::stream).count();
    }

    @Override
    public boolean hasNext() {
        return count < size;
    }

    @Override
    public Object next() {
        count++;
        if (j == values[i].length) {
            i++;
            j = 0;
        }
        return values[i][j++];
    }
}