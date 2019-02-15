package ru.job4j.tracker;

public interface UserAction {
    /**
     * The method returns a key of the option.
     *
     * @return key.
     */
    int key();

    /**
     * The main method.
     *
     * @param input   Input type object.
     * @param tracker Tracker type object.
     */
    void execute(Input input, Tracker tracker);

    /**
     * The method returns an information about certain menu item.
     *
     * @return Menu string.
     */
    String info();
}
