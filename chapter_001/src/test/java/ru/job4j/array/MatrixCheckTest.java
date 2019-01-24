package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for matrix checker.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheckTest {
    /**
     * All array elements
     * in matrix (3x3) diagonals are the same.
     */
    @Test
    public void whenData3On3MonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * All array elements
     * in matrix (3x3) diagonals are not the same.
     */
    @Test
    public void whenData3On3NotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Elements in diagonal of matrix (2x2) are the same.
     */
    @Test
    public void whenData2On2MonoThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false},
                {false, true},
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Elements in diagonal of matrix (2x2) are not the same.
     */
    @Test
    public void whenData2On2NotMonoThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false},
                {true, true},
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}
