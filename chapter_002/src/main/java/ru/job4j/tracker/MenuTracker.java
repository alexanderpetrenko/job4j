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
        this.actions[ADD] = new CreateItem();
        this.actions[SHOW] = new ShowAllItems();
        this.actions[EDIT] = new EditItem();
        this.actions[DELETE] = new DeleteItem();
        this.actions[FINDID] = new FindItemById();
        this.actions[FINDNAME] = new FindItemByName();
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
    private class CreateItem implements UserAction {
        @Override
        public int key() {
            return MenuTracker.ADD;
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

        @Override
        public String info() {
            return String.format("%s - %s", this.key(), "Добавить новую заявку");
        }
    }

    /**
     * The {@code ShowAllItems} class outputs all bid Items from the repository.
     */
    private class ShowAllItems implements UserAction {
        @Override
        public int key() {
            return MenuTracker.SHOW;
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

        @Override
        public String info() {
            return String.format("%s - %s", this.key(), "Показать все заявки");
        }
    }

    /**
     * The {@code EditItem} class implements editing an existing bid Item.
     */
    private class EditItem implements UserAction {
        @Override
        public int key() {
            return MenuTracker.EDIT;
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

        @Override
        public String info() {
            return String.format("%s - %s", this.key(), "Редактировать заявку");
        }
    }

    /**
     * The {@code DeleteItem} class implements delete operation of the existing bid from the repository.
     */
    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return MenuTracker.DELETE;
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

        @Override
        public String info() {
            return String.format("%s - %s", this.key(), "Удалить заявку");
        }
    }

    /**
     * The {@code FindItemById} class implements search a bid Item by Id.
     */
    private class FindItemById implements UserAction {
        @Override
        public int key() {
            return MenuTracker.FINDID;
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

        @Override
        public String info() {
            return String.format("%s - %s", this.key(), "Поиск заявки по Id");
        }
    }

    /**
     * The {@code FindItemById} class implements search a bid Item by its Name.
     */
    private class FindItemByName implements UserAction {
        @Override
        public int key() {
            return MenuTracker.FINDNAME;
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

        @Override
        public String info() {
            return String.format("%s - %s", this.key(), "Поиск заявки по названию");
        }
    }
}
