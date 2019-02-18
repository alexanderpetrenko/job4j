package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@code ValidateInput} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class ValidateInputTest {
    /**
     * Buffer for result.
     */
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    /**
     * Default output in console.
     */
    private final PrintStream out = System.out;

    @Before
    public void openBuffer() {
        System.setOut(new PrintStream(mem));
    }

    @After
    public void closeBuffer() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1"})
        );
        List<Integer> range = new ArrayList<>();
        range.add(1);
        input.ask("Enter", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Пожалуйста, введите целое число из диапазона пунктов меню.%n")
                )
        );
    }
}
