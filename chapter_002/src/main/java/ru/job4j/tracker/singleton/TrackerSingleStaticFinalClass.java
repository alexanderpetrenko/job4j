package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

/**
 * Singleton: Private Static Final Class. Lazy loading.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 23.02.2019
 */
public class TrackerSingleStaticFinalClass {
    /**
     * The singleton class constructor should be private.
     */
    private TrackerSingleStaticFinalClass() {
    }

    /**
     * The getter method for instance of Tracker class.
     *
     * @return The instance of Tracker class.
     */
    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * The Inner Class for holding the instance of the Tracker object.
     */
    private static final class Holder {
        /**
         * The constant of Tracker class instance.
         */
        private static final Tracker INSTANCE = new Tracker();
    }
}
