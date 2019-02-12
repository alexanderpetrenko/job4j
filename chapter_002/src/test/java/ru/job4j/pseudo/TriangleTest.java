package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for operation class of the {@code Shape} interface
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class TriangleTest {
    /**
     * Test of drawing a triangle.
     */
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        String ls = System.lineSeparator();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("   ^   ").append(ls)
                                .append("  ^ ^  ").append(ls)
                                .append(" ^   ^ ").append(ls)
                                .append("^^^^^^^").append(ls)
                                .toString()
                )
        );
    }
}
