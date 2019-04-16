package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code ConvertMatrix2List} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 16.04.2019
 */
public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = list.arrayToList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when2on2MatrixThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        List<Integer> expect = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = list.matrixToList(matrix);
        assertThat(result, is(expect));
    }
}
