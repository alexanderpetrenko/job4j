package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for User Interface.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class StartUITest {
    /**
     * Default output in console.
     */
    private final PrintStream stdout = System.out;
    /**
     * Buffer for result.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    /**
     * Constant for Line separator.
     */
    private static final String LS = System.lineSeparator();

    /**
     * Change output settings for saving program output to buffer.
     */
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    /**
     * Cancel changes for output settings and back to default.
     */
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * This method prints menu items.
     *
     * @return Menu Items
     */
    public final String getMenu() {
        return new StringBuilder().append("Меню:")
                .append(LS).append("0 - добавить новую заявку")
                .append(LS).append("1 - показать все заявки")
                .append(LS).append("2 - редактировать заявку")
                .append(LS).append("3 - удалить заявку")
                .append(LS).append("4 - поиск заявки по Id")
                .append(LS).append("5 - поиск заявки по названию")
                .append(LS).append("6 - выход").append(LS).toString();
    }

    /**
     * Test for Menu Item 0: add a new bid Item.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "description", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Test for Menu Item 1: show all Items.
     */
    @Test
    public void whenUserChooseShowAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Bid 1", "Test Item 1"));
        Item item2 = tracker.add(new Item("Bid 2", "Test Item 2"));
        Input input = new StubInput(new String[]{"1", "6"});
        this.loadOutput();
        new StartUI(input, tracker).init();
        Item[] items = tracker.findAll();
        StringBuilder result = new StringBuilder();
        result.append(this.getMenu())
                .append("------------ Вывод всех заявок --------------------").append(LS)
                .append(item1.toString()).append(LS)
                .append(item2.toString()).append(LS)
                .append("------------ Вывод всех заявок окончен ------------").append(LS)
                .append(this.getMenu());
        assertThat(this.out.toString(), is(result.toString()));
        this.backOutput();
    }

    /**
     * Test for Menu Item 2: edit a bid Item.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "description"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Test for Menu Item 3: delete a bid Item.
     */
    @Test
    public void whenDeleteItemThenTrackerDoesNotFindItemById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Delete Test", "Testing the Delete operation"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is((Item) null));
    }

    /**
     * Test for Menu Item 4: Find an existing bid Item By Id.
     */
    @Test
    public void whenUserSearchExistedItemByIdThenTrackerReturnItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find By Id Item", "Search by Id operation"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        this.loadOutput();
        new StartUI(input, tracker).init();
        StringBuilder result = new StringBuilder();
        result.append(this.getMenu())
                .append("------------ Поиск заявки по Id -------------------").append(LS)
                .append(item.toString()).append(LS)
                .append(this.getMenu());
        assertThat(this.out.toString(), is(result.toString()));
        this.backOutput();
    }

    /**
     * Test for Menu Item 4: Find a nonexistent bid Item By Id.
     */
    @Test
    public void whenUserSearchNonexistentItemByIdThenTrackerReturnMessage() {
        Tracker tracker = new Tracker();
        String id = new String("123");
        Input input = new StubInput(new String[]{"4", id, "6"});
        this.loadOutput();
        new StartUI(input, tracker).init();
        StringBuilder result = new StringBuilder();
        result.append(this.getMenu())
                .append("------------ Поиск заявки по Id -------------------").append(LS)
                .append("------------ Заявка ").append(id).append(" не найдена -------------").append(LS)
                .append(this.getMenu());
        assertThat(this.out.toString(), is(result.toString()));
        this.backOutput();
    }

    /**
     * Test for Menu Item 5: Find an existing bid Item By its Name.
     */
    @Test
    public void whenUserSearchExistedItemByNameThenTrackerReturnItem() {
        Tracker tracker = new Tracker();
        String itemName = new String("testItem");
        Item item = tracker.add(new Item(itemName, "Search by Name operation"));
        Input input = new StubInput(new String[]{"5", itemName, "6"});
        this.loadOutput();
        new StartUI(input, tracker).init();
        StringBuilder result = new StringBuilder();
        result.append(this.getMenu())
                .append("------------ Поиск заявки по названию ---------------").append(LS)
                .append(item.toString()).append(LS)
                .append("------------ Вывод найденных заявок окончен ---------------").append(LS)
                .append(this.getMenu());
        assertThat(this.out.toString(), is(result.toString()));
        this.backOutput();
    }

    /**
     * Test for Menu Item 5: Find a nonexistent bid Item By its Name.
     */
    @Test
    public void whenUserSearchNonexistentItemByNameThenTrackerReturnMessage() {
        Tracker tracker = new Tracker();
        String itemName = new String("testItem");
        Input input = new StubInput(new String[]{"5", itemName, "6"});
        this.loadOutput();
        new StartUI(input, tracker).init();
        StringBuilder result = new StringBuilder();
        result.append(this.getMenu())
                .append("------------ Поиск заявки по названию ---------------").append(LS)
                .append("------------ Заявки не найдены ------------------------").append(LS)
                .append("------------ Вывод найденных заявок окончен ---------------").append(LS)
                .append(this.getMenu());
        assertThat(this.out.toString(), is(result.toString()));
        this.backOutput();
    }
}
