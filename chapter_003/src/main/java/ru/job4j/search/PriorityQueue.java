package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;

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
    public void putFor(Task task) {
        int i = 0;
        for (; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).getPriority() >= task.getPriority()) {
                break;
            }
        }
        this.tasks.add(i, task);
    }

    /**
     * The method adds a Task to the Task List by its priority using Foreach Loop.
     *
     * @param task A Task with priority.
     */
    public void putForeach(Task task) {
        int i = 0;
        for (Task orderTask : this.tasks) {
            if (task.getPriority() < orderTask.getPriority()) {
                break;
            }
            i++;
        }
        this.tasks.add(i, task);

    }

    /**
     * The method adds a Task to the Task List by its priority using Iterator.
     *
     * @param task A Task with priority.
     */
    public void putIterator(Task task) {
        if (this.tasks.isEmpty()) {
            this.tasks.add(task);
        } else {
            ListIterator<Task> tasksIter = this.tasks.listIterator();
            while (tasksIter.hasNext()) {
                if (tasksIter.next().getPriority() >= task.getPriority()) {
                    this.tasks.add(tasksIter.previousIndex(), task);
                    break;
                }
            }
        }
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
