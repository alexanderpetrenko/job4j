package ru.job4j.tracker.singleton;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for singleton pattern (static final class) of Tracker class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 23.02.2019
 */
public class TrackerSingleStaticFinalClassTest {
    /**
     * Test for creating the single object of Tracker class.
     */
    @Test
    public void whenSingletonEnumThenOneInstance() {
        Tracker tracker1 = TrackerSingleStaticFinalClass.getInstance();
        Tracker tracker2 = TrackerSingleStaticFinalClass.getInstance();
        assertThat(tracker1, is(tracker2));
    }

    /**
     * Test for the adding Item method.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = TrackerSingleStaticFinalClass.getInstance();
        Item item = new Item("testBid", "Test Bid Description");
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }
}
