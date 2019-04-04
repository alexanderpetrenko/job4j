package ru.job4j.search;

import java.util.LinkedList;

/**
 * The {@code PriorityQueue} class describes a List of Tasks with priority.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * The method adds a Task to the Task List by its priority using For Loop.
     *
     * @param task A Task with priority.
     */
    public void put(Task task) {
        int i = (int) tasks.stream().filter(
                thisTask -> thisTask.getPriority() <= task.getPriority()
        ).count();
        this.tasks.add(i, task);
    }

    /**
     * The method returns the first Task from the Task List.
     *
     * @return A Task with the highest priority.
     */
    public Task take() {
        return this.tasks.poll();
    }
}
