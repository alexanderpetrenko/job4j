package ru.job4j.set;

import ru.job4j.list.ContainerArrayList;

import java.util.Iterator;

/**
 * {@code Simple Set} creates a dynamic Set of Data.
 *
 * @param <E> A reference type of array elements.
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 27.08.2019
 */
public class SimpleSet<E> implements Iterable<E> {
    private final ContainerArrayList<E> list;

    public SimpleSet() {
        this.list = new ContainerArrayList<>();
    }

    /**
     * Checks the uniqueness of the element in the set.
     *
     * @param e element to be checked.
     */
    private boolean isUnique(E e) {
        boolean result = true;
        for (E value : list) {
            if (value.equals(e)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Appends the specified element to the set.
     *
     * @param e element to be appended to this set.
     */
    public void add(E e) {
        if (isUnique(e)) {
            this.list.add(e);
        }
    }

    /**
     * Returns an iterator over the elements in this set.
     *
     * @return an iterator object.
     */
    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }
}
