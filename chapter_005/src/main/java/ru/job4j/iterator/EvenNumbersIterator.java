package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * {@code Even Numbers Iterator} returns the next even element of the array.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 17.05.2019
 */
public class EvenNumbersIterator implements Iterator {
    /**
     * Input array.
     */
    private int[] values;
    /**
     * The current position of the iterator.
     */
    private int index = 0;
    /**
     * The Delta of the current position to the next even element in the array.
     * (In other words {@code index + delta = next even element position}.
     */
    private int delta;

    /**
     * The Constructor initialize field {@code values}.
     *
     * @param values Input array.
     */
    public EvenNumbersIterator(int[] values) {
        this.values = values;
    }

    /**
     * The method checks if the array element is even.
     *
     * @param element Value of the array.
     * @return {@code true} if the input number is even; otherwise {@code false}.
     */
    private boolean isEven(int element) {
        return element % 2 == 0;
    }

    /**
     * Returns {@code true} if the iteration has more even elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more even elements.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (delta = 0; delta < values.length - index; delta++) {
            if (isEven(values[index + delta])) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Returns the next even element in the iteration.
     *
     * @return the next even element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("There are no Even Elements further in the array");
        }
        index += delta;
        return values[index++];
    }
}
