package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        if (index > objects.length - 1) {
            throw new ArrayIndexOutOfBoundsException("There are too many elements in array");
        }
        this.objects[index++] = model;
    }

    public void set(int position, T model) {
        if (position >= objects.length || position < 0) {
            throw new ArrayIndexOutOfBoundsException("Input Index is out of bounds");
        }
        this.objects[position] = model;
    }

    public void remove(int position) {
        if (position >= objects.length || position < 0) {
            throw new ArrayIndexOutOfBoundsException("Input Index is out of bounds");
        }
        System.arraycopy(objects, position + 1, objects, position, this.objects.length - 1);
//        for (int i = position; i < this.objects.length - 2; i++) {
//            this.objects[i] = this.objects[i + 1];
//        }
    }

    public T get(int position) {
        if (position >= objects.length || position < 0) {
            throw new ArrayIndexOutOfBoundsException("Input Index is out of bounds");
        }
        return (T) this.objects[position];
    }

    public int length() {
        return this.objects.length;
    }

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
