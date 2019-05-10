package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code Calculator} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 10.05.2019
 */
public class CalculatorTest {
    @Test
    public void whenSquareMatrixThenSumDiagonals() {
        int[][] input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Calculator calculator = new Calculator();
        assertThat(calculator.sumDiagonals(input), is(30));
    }
}
