package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@code DummyBot} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DummyBotTest {

    /**
     * Test for greeting.
     */
    @Test
    public void whenGreetBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Привет, Бот."), is("Привет, умник.")
        );
    }

    /**
     * Test for goodbye.
     */
    @Test
    public void whenByeBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Пока."), is("До скорой встречи.")
        );
    }

    /**
     * Test fot unknown question.
     */
    @Test
    public void whenUnknownBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Сколько будет 2 + 2?"),
                is("Это ставит меня в тупик. Спросите другой вопрос.")
        );
    }
}
