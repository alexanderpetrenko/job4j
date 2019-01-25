package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for removing array duplicates.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {
    /**
     * Test for array of words.
     */
    @Test
    public void whenRemoveDuplicateWordsThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = duplicate.remove(input);
        String[] expect = {"Привет", "Мир", "Супер"};
        assertThat(result, is(expect));
    }

    /**
     * Array elements are all duplicates.
     */
    @Test
    public void whenArrayAllDuplicatesThenDropIt() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"1", "1", "1", "1", "1"};
        String[] result = duplicate.remove(input);
        String[] expect = {"1"};
        assertThat(result, is(expect));
    }

    /**
     * Test for array of numbers.
     */
    @Test
    public void whenRemoveDuplicateNumbersThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"1", "1", "2", "2", "3", "3"};
        String[] result = duplicate.remove(input);
        String[] expect = {"1", "2", "3"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
