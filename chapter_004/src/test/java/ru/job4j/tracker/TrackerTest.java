package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@code Tracker} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class TrackerTest {
    /**
     * Test for the adding Item method.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    /**
     * Test for the replacing Item method.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription1");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Test for deleting an Item from a bid array.
     */
    @Test
    public void whenDeleteItemReturnTrue() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription");
        tracker.add(item);
        boolean result = tracker.delete(item.getId());
        assertThat(result, is(true));
    }

    /**
     * Test for deleting Item, which is not from a bid array.
     */
    @Test
    public void whenDeleteItemReturnFalse() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription");
        Item notItem = new Item("test1", "testDescription1");
        tracker.add(item);
        boolean result = tracker.delete(notItem.getId());
        assertThat(result, is(false));
    }

    /**
     * Test for the method, which returns all Items from array.
     */
    @Test
    public void when3ItemsInArrayFindAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1");
        Item item2 = new Item("test2", "testDescription2");
        Item item3 = new Item("test3", "testDescription3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        expected.add(item3);
        assertThat(tracker.findAll(), is(expected));
    }

    /**
     * Test for the method, which returns all Items from an empty array.
     */
    @Test
    public void whenNoItemsInArrayFindAllItems() {
        Tracker tracker = new Tracker();
        List<Item> expected = new ArrayList<>();
        assertThat(tracker.findAll(), is(expected));
    }

    /**
     * Test for the method, which finds elements from the bid array by its Name.
     */
    @Test
    public void whenExistsTwoElementsWithSameNameFindThem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test", "testDescription1");
        Item item2 = new Item("test2", "testDescription2");
        Item item3 = new Item("test", "testDescription3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item3);
        assertThat(tracker.findByName("test"), is(expected));
    }

    /**
     * Test for the method, which finds elements from the bid array by its Id.
     */
    @Test
    public void whenExistElementFindItByID() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }
}
