package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

/**
 * Singleton: Static Field. Lazy loading.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 23.02.2019
 */
public class TrackerSingleStaticField {
    /**
     * The instance of Tracker class.
     */
    private static Tracker instance;

    /**
     * The singleton class constructor should be private.
     */
    private TrackerSingleStaticField() {
    }

    /**
     * The getter method for instance of Tracker class.
     *
     * @return The instance of Tracker class.
     */
    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
