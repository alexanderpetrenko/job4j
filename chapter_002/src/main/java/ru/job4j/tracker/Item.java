package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
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
    //    public static void main(String[] args) {
//        System.out.println();
//    }
}