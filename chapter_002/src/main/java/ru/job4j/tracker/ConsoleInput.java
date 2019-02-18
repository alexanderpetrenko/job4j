package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

/**
 * The {@code ConsoleInput} class provides data input from a keyboard.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * This method displays the question and accepts an entered answer.
     *
     * @param question Question for user.
     * @return User's answer.
     */
    public String ask(String question) {
        System.out.println(question);
        return this.scanner.nextLine();
    }

    /**
     * This method displays the question and accepts an entered answer.
     *
     * @param question Question for user.
     * @param range A menu range Items.
     * @return User's answer.
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
