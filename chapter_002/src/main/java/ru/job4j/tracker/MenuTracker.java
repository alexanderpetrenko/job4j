package ru.job4j.tracker;

/**
 * The {@code MenuTracker} realizes the executing of user's operations.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class MenuTracker {
    /**
     * This field stores an Input object reference
     */
    private Input input;
    /**
     * This field stores a Tracker object reference
     */
    private Tracker tracker;
    /**
     * Menu's constants and keys for user's actions.
     */
    private static final int ADD = 0;
    private static final int SHOW = 1;
    private static final int EDIT = 2;
    private static final int DELETE = 3;
    private static final int FINDID = 4;
    private static final int FINDNAME = 5;
    /**
     * Array of user's actions.
     */
    private UserAction[] actions = new UserAction[6];

    /**
     * The class constructor.
     *
     * @param input   Input type object.
     * @param tracker Tracker type object.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * This method fills an array with user's actions.
     */
    public void fillActions() {
        this.actions[ADD] = new CreateItem(ADD, "Добавить новую заявку");
        this.actions[SHOW] = new ShowAllItems(SHOW, "Показать все заявки");
        this.actions[EDIT] = new EditItem(EDIT, "Редактировать заявку");
        this.actions[DELETE] = new DeleteItem(DELETE, "Удалить заявку");
        this.actions[FINDID] = new FindItemById(FINDID, "Поиск заявки по Id");
        this.actions[FINDNAME] = new FindItemByName(FINDNAME, "Поиск заявки по названию");
    }

    public int getActionsLength() {
        return this.actions.length;
    }

    /**
     * The method performs the appropriate action depending on the specified key.
     *
     * @param key An action key.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * This method outputs menu items.
     */
    public void show() {
        System.out.println("Меню:");
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }

    /**
     * The {@code CreateItem} class implements adding a new bid to the repository.
     */
    private class CreateItem extends BaseAction {

        public CreateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите название заявки: ");
            String description = input.ask("Введите описание заявки: ");
            Item item = new Item(name, description);
            tracker.add(item);
            System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");
            System.out.println("----- Новая заявка с названием : " + item.getName() + "-----------");
            System.out.println("----- Новая заявка с описанием : " + item.getDescription() + "-----------");
        }
    }

    /**
     * The {@code ShowAllItems} class outputs all bid Items from the repository.
     */
    private class ShowAllItems extends BaseAction {

        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Вывод всех заявок --------------------");
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println(item.toString());
            }
            System.out.println("------------ Вывод всех заявок окончен ------------");
        }
    }

    /**
     * The {@code EditItem} class implements editing an existing bid Item.
     */
    private class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки ----------------");
            String id = input.ask("Введите Id заявки для редактирования: ");
            String name = input.ask("Введите новое название заявки: ");
            String description = input.ask("Введите новое описание заявки: ");
            Item newItem = new Item(name, description);
            if (tracker.replace(id, newItem)) {
                System.out.println("------------ Заявка с Id " + newItem.getId() + " отредактирована -----------");
                System.out.println("------------ Название заявки " + newItem.getName() + " -----------");
                System.out.println("------------ Описание заявки " + newItem.getDescription() + " -----------");
            } else {
                System.out.println("------------ Операция отклонена! Заявка не найдена ----");
            }
        }
    }

    /**
     * The {@code DeleteItem} class implements delete operation of the existing bid from the repository.
     */
    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки ----------------------");
            String id = input.ask("Введите Id заявки: ");
            if (tracker.delete(id)) {
                System.out.println("------------ Заявка удалена успешно -------------------");
            } else {
                System.out.println("------------ Операция отклонена! Заявка не найдена ----");
            }
        }
    }

    /**
     * The {@code FindItemById} class implements search a bid Item by Id.
     */
    private class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по Id -------------------");
            String id = input.ask("Введите Id заявки: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item.toString());
            } else {
                System.out.println("------------ Заявка " + id + " не найдена -------------");
            }
        }
    }

    /**
     * The {@code FindItemById} class implements search a bid Item by its Name.
     */
    private class FindItemByName extends BaseAction {

        public FindItemByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по названию ---------------");
            String name = input.ask("Введите название заявки: ");
            Item[] foundItems = tracker.findByName(name);
            if (foundItems.length == 0) {
                System.out.println("------------ Заявки не найдены ------------------------");
            } else {
                for (Item item : foundItems) {
                    System.out.println(item.toString());
                }
            }
            System.out.println("------------ Вывод найденных заявок окончен ---------------");
        }
    }
}
