package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Array search test.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindLoopTest {
    /**
     * The requirement element is in data array.
     */
    @Test
    public void whenArraySearch5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * The requirement element is not in data array.
     */
    @Test
    public void whenArraySearch3ThenMinus1() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{10, 20, 30, 40, 50};
        int value = 3;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }

    /**
     * Initial data array consists of negative numbers.
     */
    @Test
    public void whenArrayHasNegativeNumbers() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{-5, -10, -3};
        int value = -10;
        int result = find.indexOf(input, value);
        int expect = 1;
        assertThat(result, is(expect));
    }
}
