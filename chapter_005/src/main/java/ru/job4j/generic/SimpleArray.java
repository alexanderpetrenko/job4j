package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * {@code Simple Array} creates a universal array wrapper
 * and provides universal methods for working with input array.
 *
 * @param <T> A reference type of array elements.
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 21.05.2019
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * Input data array.
     */
    private Object[] objects;
    /**
     * Position for the next input element.
     */
    int index = 0;

    /**
     * Constructor defines the Length of the input data array.
     *
     * @param size Length of the data array.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Adds a new element to the data array.
     *
     * @param model A new array element.
     */
    public void add(T model) {
        if (index > objects.length - 1) {
            throw new ArrayIndexOutOfBoundsException("There are too many elements in array");
        }
        this.objects[index++] = model;
    }

    /**
     * Changes value of existing array element.
     *
     * @param position Position of changing array element.
     * @param model    A new element value.
     */
    public void set(int position, T model) {
        if (position >= objects.length || position < 0) {
            throw new ArrayIndexOutOfBoundsException("Input Index is out of bounds");
        }
        this.objects[position] = model;
    }

    /**
     * Deletes an existing array element.
     *
     * @param position Position of deleting array element.
     */
    public void remove(int position) {
        if (position >= objects.length || position < 0) {
            throw new ArrayIndexOutOfBoundsException("Such element does not exist");
        }
        System.arraycopy(objects, position + 1, objects, position, this.objects.length - 1 - position);
        objects = Arrays.copyOf(objects, this.objects.length - 1);
    }

    /**
     * Returns value of array element.
     *
     * @param position Position of the array element.
     * @return Value of array element.
     */
    public T get(int position) {
        if (position >= objects.length || position < 0) {
            throw new ArrayIndexOutOfBoundsException("Input Index is out of bounds");
        }
        return (T) this.objects[position];
    }

    /**
     * Returns array length.
     *
     * @return quantity of all array elements
     */
    public int length() {
        return this.objects.length;
    }

    /**
     * The method creates an iterator for the data array.
     *
     * @return An Iterator object.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < objects.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[index++];
            }
        };
    }
}
