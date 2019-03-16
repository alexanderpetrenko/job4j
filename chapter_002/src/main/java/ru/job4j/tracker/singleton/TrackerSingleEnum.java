package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.ArrayList;

/**
 * Singleton: enum. Eager loading.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 23.02.2019
 */
public enum TrackerSingleEnum {
    INSTANCE;

    private static final Tracker TRACKER = new Tracker();

    /**
     * The method that implements adding a bid to the repository.
     *
     * @param item A new bid item.
     * @return A new bid item.
     */
    public Item add(Item item) {
        return TRACKER.add(item);
    }

    /**
     * The method replaces certain bid Item for a new one.
     *
     * @param id   Id of an Item, that would be replaced.
     * @param item A replacing bid Item.
     * @return {@code true} if the operation was success; otherwise {@code false}.
     */
    public boolean replace(String id, Item item) {
        return TRACKER.replace(id, item);
    }

    /**
     * The method deletes a certain bid Item from the repository array.
     *
     * @param id Id of the deleting Item.
     * @return {@code true} if the operation was success; otherwise {@code false}.
     */
    public boolean delete(String id) {
        return TRACKER.delete(id);
    }

    /**
     * The method returns all bid Items from a repository.
     *
     * @return An array of bid Items.
     */
    public ArrayList<Item> findAll() {
        return TRACKER.findAll();
    }

    /**
     * The method searches for the bid Item by Name.
     *
     * @param key Name of the bid Item.
     * @return An array of the found Items.
     */
    public ArrayList<Item> findByName(String key) {
        return TRACKER.findByName(key);
    }

    /**
     * The method searches for the bid Item by Id.
     *
     * @param id Id of the bid Item.
     * @return found Item; otherwise the method returns null.
     */
    public Item findById(String id) {
        return TRACKER.findById(id);
    }
}
