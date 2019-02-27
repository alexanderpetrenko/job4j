package ru.job4j.search;

/**
 * The {@code Task} class describes a Task with priority.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class Task {
    private String description;
    private int priority;

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
