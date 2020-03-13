package ru.job4j.map;

/**
 * An object that maps keys to values.
 *
 * @param <K> the type of keys maintained by this map.
 * @param <V> the type of mapped values.
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 13.03.2020
 */
public interface BaseHashMap<K, V> extends Iterable {

    boolean insert(K key, V value);

    V get(K key);

    boolean delete(K key);
}
