package ru.job4j.list;

/**
 * {@code Simple Container} interface is used for creating lists of data.
 *
 * @param <E> A reference type of array elements.
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 22.05.2019
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * Appends the specified element to the end of this list.
     *
     * @param value element to be appended to this list.
     */
    void add(E value);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return.
     * @return the element at the specified position in this list.
     **/
    E get(int index);
}
