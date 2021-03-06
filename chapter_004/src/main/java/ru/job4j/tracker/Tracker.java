package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code Tracker} class provides a storage of bids and operations with them.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class Tracker {
    /**
     * List of items.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * The method that implements adding a bid to the repository.
     *
     * @param item A new bid item.
     * @return A new bid item.
     */
    public Item add(Item item) {
        item.setId(this.generateId(item.getCreated()));
        this.items.add(item);
        return item;
    }

    /**
     * The method replaces certain bid Item for a new one.
     *
     * @param id   Id of an Item, that would be replaced.
     * @param item A replacing bid Item.
     * @return {@code true} if the operation was success; otherwise {@code false}.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.set(i, item);
                this.items.get(i).setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * The method deletes a certain bid Item from the repository array.
     *
     * @param id Id of the deleting Item.
     * @return {@code true} if the operation was success; otherwise {@code false}.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * The method returns all bid Items from a repository.
     *
     * @return An array of bid Items.
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * The method searches for the bid Item by Name.
     *
     * @param key Name of the bid Item.
     * @return An array of the found Items.
     */
    public List<Item> findByName(String key) {
        return items.stream()
                .filter(item -> item.getName().equals(key))
                .collect(Collectors.toList());
    }

    /**
     * The method searches for the bid Item by Id.
     *
     * @param id Id of the bid Item.
     * @return found Item; otherwise the method returns null.
     */
    public Item findById(String id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    /**
     * The method generates a unique key for the bid.
     *
     * @return A unique key.
     */
    public String generateId(long created) {
        return String.valueOf(created + Math.random());
    }
}
