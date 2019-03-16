package ru.job4j.coffee;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@code CoffeeMachine} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 16.03.2019
 */
public class CoffeeMachineTest {
    /**
     * Test of the situation, when a customer needs change.
     */
    @Test
    public void whenCustomerHasEnoughMoney() {
        int[] coins = new int[]{1, 2, 5, 10};
        CoffeeMachine machine = new CoffeeMachine(coins);
        int[] expected = new int[]{10, 5};
        assertThat(machine.changes(50, 35), is(expected));
    }

    /**
     * Test of the situation, when a customer doesn't need change.
     */
    @Test
    public void whenCustomerNeedNotChange() {
        int[] coins = new int[]{1, 2, 5, 10};
        CoffeeMachine machine = new CoffeeMachine(coins);
        int[] expected = new int[]{0};
        assertThat(machine.changes(50, 50), is(expected));
    }

    /**
     * Test of the situation, when a customer hasn't got enough money.
     */
    @Test(expected = NotEnoughMoney.class)
    public void whenCustomerHasNotEnoughMoney() {
        int[] coins = new int[]{1, 2, 5, 10};
        CoffeeMachine machine = new CoffeeMachine(coins);
        machine.changes(35, 50);
    }
}
