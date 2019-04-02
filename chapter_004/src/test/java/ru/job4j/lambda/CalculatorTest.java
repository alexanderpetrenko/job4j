package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * The {@code CalculatorTest} class provides testing of
 * calculating mathematical function in a range using Lambda expression.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 03.04.2019
 */
public class CalculatorTest {
    /**
     * Test for Linear Function.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Calculator calc = new Calculator();
        List<Double> result = calc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * Test for Quadratic Function.
     */
    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Calculator calc = new Calculator();
        List<Double> result = calc.diapason(-3, 4, x -> x * x + 1);
        List<Double> expected = Arrays.asList(10D, 5D, 2D, 1D, 2D, 5D, 10D);
        assertThat(result, is(expected));
    }

    /**
     * Test for Logarithmic Function.
     */
    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Calculator calc = new Calculator();
        List<Double> result = calc.diapason(9, 12, Math::log10);
        List<Double> expected = Arrays.asList(0.95D, 1D, 1.041D);
        expected.forEach(x -> assertThat(result.iterator().next(), closeTo(x, 0.1)));
    }
}
