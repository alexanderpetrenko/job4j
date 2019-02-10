package ru.job4j.tracker;

import java.util.Arrays;

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
    private final Item[] items = new Item[100];
    /**
     * Next item index.
     */
    private int position = 0;

    /**
     * The method that implements adding a bid to the repository.
     *
     * @param item A new bid item.
     * @return A new bid item.
     */
    public Item add(Item item) {
        item.setId(this.generateId(item.getCreated()));
        this.items[this.position++] = item;
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
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                this.items[i].setId(id);
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
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.position - 1 - i);
                this.items[this.position - 1] = null;
                this.position--;
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
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * The method searches for the bid Item by Name.
     *
     * @param key Name of the bid Item.
     * @return An array of the found Items.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int j = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                result[j++] = this.items[i];
            }
        }
        return Arrays.copyOf(result, j);
    }

    /**
     * The method searches for the bid Item by Id.
     *
     * @param id Id of the bid Item.
     * @return found Item; otherwise the method returns null.
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                result = this.items[i];
                break;
            }
        }
        return result;
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
