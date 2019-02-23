package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

/**
 * Singleton: Static Final Field. Eager loading.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 23.02.2019
 */
public class TrackerSingleStaticFinalField {
    /**
     * The constant of Tracker class instance.
     */
    public static final Tracker INSTANCE = new Tracker();

    /**
     * The singleton class constructor should be private.
     */
    private TrackerSingleStaticFinalField() {
    }
}
