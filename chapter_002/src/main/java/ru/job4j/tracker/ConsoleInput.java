package ru.job4j.tracker;

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
}
