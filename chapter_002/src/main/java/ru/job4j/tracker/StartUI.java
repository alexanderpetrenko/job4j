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
                case ADD:
                    this.createItem();
                    break;
                case SHOW:
                    this.showAllItems();
                    break;
                case EDIT:
                    this.editItem();
                    break;
                case DELETE:
                    this.deleteItem();
                    break;
                case FINDID:
                    this.findItemById();
                    break;
                case FINDNAME:
                    this.findItemByName();
                    break;
                case EXIT:
                    exit = true;
                default:
            }
        }
    }

    /**
     * This method shows user's menu.
     */
    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("0 - добавить новую заявку");
        System.out.println("1 - показать все заявки");
        System.out.println("2 - редактировать заявку");
        System.out.println("3 - удалить заявку");
        System.out.println("4 - поиск заявки по Id");
        System.out.println("5 - поиск заявки по названию");
        System.out.println("6 - выход");
    }

    /**
     * The method provides adding a new bid to a storage array.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите название заявки: ");
        String description = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, description);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * The method realizes an output of all bids from the repository.
     */
    private void showAllItems() {
        System.out.println("------------ Вывод всех заявок --------------------");
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
            System.out.println(item.toString());
        }
        System.out.println("------------ Вывод всех заявок окончен ------------");
    }

    /**
     * The method realizes an editing of a bid Item using its Id.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки ----------------");
        String id = this.input.ask("Введите Id заявки для редактирования: ");
        String name = this.input.ask("Введите новое название заявки: ");
        String description = this.input.ask("Введите новое описание заявки: ");
        Item newItem = new Item(name, description);
        if (this.tracker.replace(id, newItem)) {
            System.out.println("------------ Заявка с getId " + newItem.getId() + " отредактирована -----------");
        } else {
            System.out.println("------------ Операция отклонена! Заявка не найдена ----");
        }
    }

    /**
     * The method realizes a deleting of a bid Item using its Id.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки ----------------------");
        String id = this.input.ask("Введите Id заявки: ");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Заявка удалена успешно -------------------");
        } else {
            System.out.println("------------ Операция отклонена! Заявка не найдена ----");
        }
    }

    /**
     * The method implements search a bid Item by Id.
     */
    private void findItemById() {
        System.out.println("------------ Поиск заявки по Id -------------------");
        String id = this.input.ask("Введите Id заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("------------ Заявка " + id + " не найдена -------------");
        }
    }

    /**
     * The method implements search a bid Item by its Name.
     */
    private void findItemByName() {
        System.out.println("------------ Поиск заявки по названию ---------------");
        String name = this.input.ask("Введите название заявки: ");
        Item[] foundItems = this.tracker.findByName(name);
        if (foundItems.length == 0) {
            System.out.println("------------ Заявки не найдены ------------------------");
        } else {
            for (Item item : foundItems) {
                System.out.println(item.toString());
            }
        }
        System.out.println("------------ Вывод найденных заявок окончен ---------------");
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
