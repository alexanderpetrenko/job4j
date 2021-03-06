package ru.job4j.tracker;

import java.util.List;

/**
 * The {@code StubInput} class is used for imitation of user behavior.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class StubInput implements Input {
    /**
     * This field consists the sequence of user responses.
     */
    private final String[] value;
    /**
     * The field counts the number of calls of the {@code ask} method.
     */
    private int position;

    /**
     * The class constructor.
     *
     * @param value An array of user responses.
     */
    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * The method imitates a user behavior.
     *
     * @param question Question from program.
     * @return A user answer from the array of user responses.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    /**
     * The method imitates a user behavior.
     *
     * @param question Question from program.
     * @param range    Menu's Items range.
     * @return A user answer from the array of user responses.
     */
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }
}
