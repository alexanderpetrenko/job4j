package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    /**
     * Test of addition operation.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test of subtraction operation.
     */
    @Test
    public void whenFiveMinusThreeThenTwo() {
        Calculator calc = new Calculator();
        calc.subtract(5D, 3D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test of division operation.
     */
    @Test
    public void whenTwelveDivThreeThanFour() {
        Calculator calc = new Calculator();
        calc.div(12D, 3D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }

    /**
     * Test of multiplication operation
     */
    @Test
    public void whenFiveMultiplyTwoThenTen() {
        Calculator calc = new Calculator();
        calc.multiple(5D, 2D);
        double result = calc.getResult();
        double expected = 10D;
        assertThat(result, is(expected));
    }
}