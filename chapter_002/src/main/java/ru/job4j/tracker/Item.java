package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String description;
    private long created;
    private String[] comments;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.created = System.currentTimeMillis();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
