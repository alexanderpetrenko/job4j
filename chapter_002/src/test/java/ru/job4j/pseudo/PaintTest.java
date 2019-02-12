package ru.job4j.pseudo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for a context class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class PaintTest {
    /**
     * Test of drawing a square.
     */
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        String ls = System.lineSeparator();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++").append(ls)
                                .append("+  +").append(ls)
                                .append("+  +").append(ls)
                                .append("++++").append(ls)
                                .append(ls)
                                .toString()
                )
        );
        System.setOut(stdout);
    }

    /**
     * Test of drawing a triangle.
     */
    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        String ls = System.lineSeparator();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("   ^   ").append(ls)
                                .append("  ^ ^  ").append(ls)
                                .append(" ^   ^ ").append(ls)
                                .append("^^^^^^^").append(ls)
                                .append(ls)
                                .toString()
                )
        );
        System.setOut(stdout);
    }
}
