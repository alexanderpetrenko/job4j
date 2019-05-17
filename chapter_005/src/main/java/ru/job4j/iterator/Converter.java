package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * {@code Converter} receives an Iterator object, which consists of Iterators with Integer numbers,
 * and returns an Iterator object, which consists of Integer numbers.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 17.05.2019
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> iterators) {
        return new Iterator<>() {
            Iterator<Integer> current = iterators.next();

            @Override
            public boolean hasNext() {
                if (!this.current.hasNext() && iterators.hasNext()) {
                    current = iterators.next();
                }
                return this.current.hasNext();
            }

            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException("There are no further elements");
                }
                return this.current.next();
            }
        };
    }
}
