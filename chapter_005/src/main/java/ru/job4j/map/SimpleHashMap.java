package ru.job4j.map;

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
    /**
     * Default quantity of key-value mappings.
     */
    private static final int DEFAULT_SIZE = 8;
    /**
     * Default value of a load factor.
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     * The maximum size of array to allocate.
     */
    private static final int MAX_ARRAY_SIZE = 512;
    /**
     * The hash table data.
     */
    private Node<?, ?>[] table;
    /**
     * The load factor for the hashtable.
     */
    private float loadFactor;
    /**
     * The number of key-value mappings contained in this map.
     */
    private int count;
    /**
     * The next size value at which to resize (capacity * load factor).
     */
    private int threshold;
    /**
     * The number of times this HashMap has been structurally modified.
     */
    private int modCount;

    public SimpleHashMap() {
        this(DEFAULT_SIZE);
    }

    public SimpleHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public SimpleHashMap(int initialCapacity, float loadFactor) {
        this.table = new Node[initialCapacity];
        this.loadFactor = loadFactor;
        this.modCount = 0;
        this.threshold = (int) Math.min(initialCapacity * loadFactor, MAX_ARRAY_SIZE);
    }

    private int index(K key) {
        return (key == null) ? 0 : key.hashCode() & (table.length - 1);
    }

    private void resize() {
        int oldCapacity = this.table.length;
        Node<?, ?>[] oldMap = this.table;
        int newCapacity = oldCapacity * 2;
        if (newCapacity > MAX_ARRAY_SIZE) {
            if (oldCapacity == MAX_ARRAY_SIZE) {
                // Keep running with MAX_ARRAY_SIZE buckets
                return;
            }
            newCapacity = MAX_ARRAY_SIZE;
        }
        this.modCount++;
        this.threshold = (int) Math.min(newCapacity * this.loadFactor, MAX_ARRAY_SIZE);
        Node<?, ?>[] newMap = new Node[newCapacity];
        this.table = newMap;
        for (int i = 0; i < oldCapacity; i++) {
            if (oldMap[i] != null) {
                @SuppressWarnings("unchecked")
                int index = this.index((K) oldMap[i].key);
                newMap[index] = oldMap[i];
            }
        }
    }

    public int length() {
        return this.count;
    }

    @Override
    public boolean insert(K key, V value) {
        boolean result;
        if (this.count >= this.threshold) {
            this.resize();
        }
        int i = index(key);
        if (table[i] != null) {
            result = false;
        } else {
            table[i] = new Node<>(key, value);
            this.count++;
            this.modCount++;
            result = true;
        }
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        V result = null;
        int i = this.index(key);
        if (i < this.table.length && i >= 0) {
            result = (V) this.table[i].value;
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
            this.count--;
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
            private int count = SimpleHashMap.this.count;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.count > 0;
            }

            @Override
            @SuppressWarnings("unchecked")
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
                        this.count--;
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
