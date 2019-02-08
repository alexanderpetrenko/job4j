package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Tracker {
    /**
     * List of items.
     */
    private final Item[] items = new Item[100];
    /**
     * Next item index.
     */
    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
            }
        }
        return result;
    }

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

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

//    public Item[] findByName(String key){
//        Item[] result;
//    }

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

    public String generateId() {
        return LocalDateTime.now().toString() + Math.random();
    }
}
