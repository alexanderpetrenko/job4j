package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for merge sort.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ExamTaskTest {
    /**
     * The first input array is shorter than the second.
     */
    @Test
    public void whenFirst3AndSecond5ThenMerge8() {
        ExamTask task = new ExamTask();
        int[] firstArray = new int[]{3, 5, 7};
        int[] secondArray = new int[]{1, 2, 4, 6, 8};
        int[] result = task.merge(firstArray, secondArray);
        int[] expectArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(result, is(expectArray));
    }

    /**
     * The second input array is shorter than the first.
     */
    @Test
    public void whenFirst5AndSecond3ThenMerge8() {
        ExamTask task = new ExamTask();
        int[] firstArray = new int[]{1, 2, 4, 6, 8};
        int[] secondArray = new int[]{3, 5, 7};
        int[] result = task.merge(firstArray, secondArray);
        int[] expectArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(result, is(expectArray));
    }

    /**
     * Two equals input arrays have the same elements.
     */
    @Test
    public void whenFirst3AndSecond3ThenMerge6() {
        ExamTask task = new ExamTask();
        int[] inputArray = new int[]{1, 2, 3};
        int[] result = task.merge(inputArray, inputArray);
        int[] expectArray = new int[]{1, 1, 2, 2, 3, 3};
        assertThat(result, is(expectArray));
    }
}
