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
}
