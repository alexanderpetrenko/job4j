package ru.job4j.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * {@code Simple Hash Map} creates an object that maps keys to values.
 * A map cannot contain duplicate keys.
 *
 * @param <K> the type of keys maintained by this map.
 * @param <V> the type of mapped values.
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 13.03.2020
 */
public class SimpleHashMap<K, V> implements BaseHashMap<K, V> {

    private static final int DEFAULT_SIZE = 8;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node<?, ?>[] table;
    private float loadFactor;

    private int quantity;

    private int modCount;

    public SimpleHashMap() {
        this(DEFAULT_SIZE);
    }

    public SimpleHashMap(int size) {
        this(size, DEFAULT_LOAD_FACTOR);
    }

    public SimpleHashMap(int size, float loadFactor) {
        this.table = new Node[size];
        this.loadFactor = loadFactor;
        this.modCount = 0;
    }

    private int index(K key) {
        return (key == null) ? 0 : key.hashCode() & (table.length - 1);
    }

    private void resize() {
        if (this.quantity >= this.table.length * this.loadFactor) {
            this.table = Arrays.copyOf(this.table, this.table.length * 2);
        }
    }

    public int length() {
        return this.quantity;
    }

    @Override
    public boolean insert(K key, V value) {
        boolean result;
        this.resize();
        int i = index(key);
        if (table[i] != null) {
            result = false;
        } else {
            table[i] = new Node<>(key, value);
            this.quantity++;
            this.modCount++;
            result = true;
        }
        return result;
    }

    @Override
//    @SuppressWarnings("unchecked")
    public V get(K key) {
        V result = null;
        int i = this.index(key);
        if (i < this.table.length && i >= 0) {
            if (this.table[i].key.equals(key)) {
                result = (V) this.table[i].value;
            }
        }
        return result;
    }

    @Override
    public boolean delete(K key) {
        boolean result;
        if (this.table[this.index(key)] == null) {
            result = false;
        } else {
            this.table[this.index(key)] = null;
            this.quantity--;
            this.modCount++;
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String ls = System.lineSeparator();
        result.append("SimpleHashMap{").append(ls);
        int i = 0;
        for (Node bucket : table) {
            if (bucket != null) {
                result.append(i++).append(". ").
                        append("[").append(bucket.key).append("]->").append(bucket.value).
                        append(ls);
            } else {
                result.append(i++).append(". ").append(ls);
            }
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = SimpleHashMap.this.modCount;
            private int quantity = SimpleHashMap.this.quantity;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.quantity > 0;
            }

            @Override
            public V next() throws NoSuchElementException, ConcurrentModificationException {
                if (this.expectedModCount != SimpleHashMap.this.modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                V result = null;
                while (index < SimpleHashMap.this.table.length) {
                    if (SimpleHashMap.this.table[index] != null) {
                        result = (V) SimpleHashMap.this.table[index++].value;
                        this.quantity--;
                        break;
                    } else {
                        index++;
                    }
                }
                return result;
            }
        };
    }

    private static class Node<K, V> {
        final K key;
        V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
