package ru.job4j.tracker;

import java.util.List;

/**
 * The {@code ValidateInput} class provides data input from a keyboard and its validation.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class ValidateInput implements Input {
    /**
     * Data source field.
     */
    private final Input input;

    /**
     * Class constructor.
     *
     * @param input Data source.
     */
    public ValidateInput(Input input) {
        this.input = input;
    }

    /**
     * This method displays the question and accepts an entered answer.
     *
     * @param question Question for user.
     * @return User's answer.
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * This method displays the question and accepts an entered answer.
     *
     * @param question Question for user.
     * @param range    A menu range Items.
     * @return User's answer.
     */
    @Override
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int key = -1;
        do {
            try {
                key = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Пожалуйста, выберите номер пункта меню.");
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста, введите целое число из диапазона пунктов меню.");
            }
        } while (invalid);
        return key;
    }
}
