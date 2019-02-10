package ru.job4j.tracker;

public class StartUI {
    /**
     * Menu's constant for adding a new bid.
     */
    private static final String ADD = "0";
    /**
     * Menu's constant for showing all bids.
     */
    private static final String SHOW = "1";
    /**
     * Menu's constant for editing a bid's Item.
     */
    private static final String EDIT = "2";
    /**
     * Menu's constant fot deleting a bid's Item.
     */
    private static final String DELETE = "3";
    /**
     * Menu's constant for finding a bid Item by its Id.
     */
    private static final String FINDID = "4";
    /**
     * Menu's constant for finding a bid Item by its Name.
     */
    private static final String FINDNAME = "5";
    /**
     * Constant for exit from a loop.
     */
    private static final String EXIT = "6";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            switch (answer) {
                case ADD: {
                    this.createItem();
                    break;
                }
                case SHOW: {

                }
                case EDIT: {

                }
                case DELETE: {

                }
                case FINDID:{

                }
                case FINDNAME:{

                }
                case EXIT: {
                    exit = true;
                }
                default:
            }
        }
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки: ");
        String description = this.input.ask("Введите описание заявки: ");
    }

    private void showMenu() {

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
