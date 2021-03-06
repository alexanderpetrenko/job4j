package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * The {@code StartUI} realizes the user's interface.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class StartUI {
    /**
     * Receive data from the user.
     */
    private final Input input;
    /**
     * The storage of bids.
     */
    private final Tracker tracker;
    /**
     * Functional interface Consumer.
     */
    private final Consumer<String> output;
    /**
     * Exit flag.
     * The program is working while the flag is {@code true}.
     */
    private boolean working = true;

    /**
     * The class constructor which initialized class fields.
     *
     * @param input   Data input.
     * @param tracker The bids storage.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * The main program loop
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("Выбор действия: ", range));
        } while (this.working);
    }

    public void stop() {
        this.working = false;
    }

    /**
     * Run the program.
     *
     * @param args Command line arguments as an array of String objects.
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker(),
                System.out::println
        ).init();
    }
}
