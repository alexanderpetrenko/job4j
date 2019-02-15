package ru.job4j.tracker;

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
     * The class constructor which initialized class fields.
     *
     * @param input   Data input.
     * @param tracker The bids storage.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * The main program loop
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("Выбор действия: ")));
        } while (!"y".equals(this.input.ask("Выйти? (y): ")));
    }

    /**
     * Run the program.
     *
     * @param args Command line arguments as an array of String objects.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
