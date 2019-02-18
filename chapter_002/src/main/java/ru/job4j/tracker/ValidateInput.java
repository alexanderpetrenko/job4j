package ru.job4j.tracker;

import java.util.List;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int key = -1;
        do {
            try {
                key = super.ask(question, range);
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
