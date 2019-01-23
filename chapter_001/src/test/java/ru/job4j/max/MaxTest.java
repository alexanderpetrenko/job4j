package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@code Max} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {

    /**
     * The second number is bigger than the first.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * The first number is bigger than the second.
     */
    @Test
    public void whenFirstBiggerSecond() {
        Max maxim = new Max();
        int result = maxim.max(5, 3);
        assertThat(result, is(5));
    }

    /**
     * The first number equals the second.
     */
    @Test
    public void whenFirstEqualsSecond() {
        Max maxim = new Max();
        int result = maxim.max(3, 3);
        assertThat(result, is(3));
    }

    /**
     * The first number is bigger than the second and the third.
     */
    @Test
    public void whenFirstBiggerThanSecondAndThird() {
        Max maxim = new Max();
        int result = maxim.max(5, 3, 1);
        assertThat(result, is(5));
    }

    /**
     * The second number is bigger than the first and the third.
     */
    @Test
    public void whenSecondBiggerThanFirstAndThird() {
        Max maxim = new Max();
        int result = maxim.max(3, 5, 1);
        assertThat(result, is(5));
    }

    /**
     * The third number is bigger than the first and the second.
     */
    @Test
    public void whenThirdBiggerThanFirstAndSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 3, 5);
        assertThat(result, is(5));
    }

    /**
     * Three numbers are equal.
     */
    @Test
    public void whenThreeNumbersEqual() {
        Max maxim = new Max();
        int result = maxim.max(9, 9, 9);
        assertThat(result, is(9));
    }
}
