package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.BishopBlack;
import ru.job4j.chess.figures.white.BishopWhite;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Figures behavior test.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class FiguresTest {
    /**
     * Test for Wrong Move of the Black Bishop Figure.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenBlackBishopWrongWayThenImpossibleMoveException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B8);
        bishopBlack.way(Cell.B8, Cell.H1);
    }

    /**
     * Test for Right Move of the Black Bishop Figure.
     */
    @Test
    public void whenBlackBishopRightWayThenWayContainsDest() {
        Cell source = Cell.B8;
        Cell dest = Cell.H2;
        BishopBlack bishopBlack = new BishopBlack(source);
        Cell[] way = bishopBlack.way(source, dest);
        assertThat(way[way.length - 1], is(dest));
        assertThat(way.length, is(6));
    }

    /**
     * Test for Wrong Move of the White Bishop Figure.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenWhiteBishopWrongWayThenImpossibleMoveException() {
        BishopWhite bishopWhite = new BishopWhite(Cell.B1);
        bishopWhite.way(Cell.B1, Cell.H6);
    }

    /**
     * Test for Right Move of the White Bishop Figure.
     */
    @Test
    public void whenWhiteBishopRightWayThenWayContainsDest() {
        Cell source = Cell.B1;
        Cell dest = Cell.H7;
        BishopBlack bishopBlack = new BishopBlack(source);
        Cell[] way = bishopBlack.way(source, dest);
        assertThat(way[way.length - 1], is(dest));
        assertThat(way.length, is(6));
    }
}
