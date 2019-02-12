package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
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
     * Default output in console.
     */
    private final PrintStream stdout = System.out;
    /**
     * Buffer for result.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Test of drawing a square.
     */
    @Test
    public void whenDrawSquare() {
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
    }

    /**
     * Test of drawing a triangle.
     */
    @Test
    public void whenDrawTriangle() {
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
    }
}
