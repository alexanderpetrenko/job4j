package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.*;
import ru.job4j.chess.figures.white.*;

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

    /**
     * Test for Wrong Move of the Black Pawn Figure.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenBlackPawnWrongWayThenImpossibleMoveException() {
        PawnBlack pawnBlack = new PawnBlack(Cell.B8);
        pawnBlack.way(Cell.B8, Cell.H1);
    }

    /**
     * Test for Right Move of the Black Pawn Figure.
     */
    @Test
    public void whenBlackPawnRightWayThenWayContainsDest() {
        Cell source = Cell.E6;
        Cell dest = Cell.E5;
        PawnBlack pawnBlack = new PawnBlack(source);
        Cell[] way = pawnBlack.way(source, dest);
        assertThat(way[0], is(dest));
        assertThat(way.length, is(1));
    }

    /**
     * Test for Wrong Move of the White Pawn Figure.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenWhitePawnWrongWayThenImpossibleMoveException() {
        PawnWhite pawnWhite = new PawnWhite(Cell.E6);
        pawnWhite.way(Cell.E6, Cell.H1);
    }

    /**
     * Test for Right Move of the White Pawn Figure.
     */
    @Test
    public void whenWhitePawnRightWayThenWayContainsDest() {
        Cell source = Cell.E6;
        Cell dest = Cell.E7;
        PawnWhite pawnWhite = new PawnWhite(source);
        Cell[] way = pawnWhite.way(source, dest);
        assertThat(way[0], is(dest));
        assertThat(way.length, is(1));
    }

    /**
     * Test for Wrong Move of the Black King Figure.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenBlackKingWrongWayThenImpossibleMoveException() {
        KingBlack kingBlack = new KingBlack(Cell.D4);
        kingBlack.way(Cell.D4, Cell.D6);
    }

    /**
     * Test for Right Move of the Black King Figure.
     */
    @Test
    public void whenBlackKingRightWayThenWayContainsDest() {
        Cell source = Cell.D4;
        Cell dest = Cell.D5;
        KingBlack kingBlack = new KingBlack(source);
        Cell[] way = kingBlack.way(source, dest);
        assertThat(way[way.length - 1], is(dest));
        assertThat(way.length, is(1));
    }

    /**
     * Test for Wrong Move of the White King Figure.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenWhiteKingWrongWayThenImpossibleMoveException() {
        KingWhite kingWhite = new KingWhite(Cell.D4);
        kingWhite.way(Cell.D4, Cell.B4);
    }

    /**
     * Test for Right Move of the White King Figure.
     */
    @Test
    public void whenWhiteKingRightWayThenWayContainsDest() {
        Cell source = Cell.D4;
        Cell dest = Cell.E5;
        KingWhite kingWhite = new KingWhite(source);
        Cell[] way = kingWhite.way(source, dest);
        assertThat(way[way.length - 1], is(dest));
        assertThat(way.length, is(1));
    }

    /**
     * Test for Wrong Move of the Black Queen Figure.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenBlackQueenWrongWayThenImpossibleMoveException() {
        QueenBlack queenBlack = new QueenBlack(Cell.D4);
        queenBlack.way(Cell.D4, Cell.G6);
    }

    /**
     * Test for Right Move of the Black Queen Figure.
     */
    @Test
    public void whenBlackQueenRightWayThenWayContainsDest() {
        Cell source = Cell.D4;
        Cell dest = Cell.A1;
        QueenBlack queenBlack = new QueenBlack(source);
        Cell[] way = queenBlack.way(source, dest);
        assertThat(way[way.length - 1], is(dest));
        assertThat(way.length, is(3));
    }

    /**
     * Test for Wrong Move of the White Queen Figure.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenWhiteQueenWrongWayThenImpossibleMoveException() {
        QueenWhite queenWhite = new QueenWhite(Cell.D4);
        queenWhite.way(Cell.D4, Cell.C2);
    }

    /**
     * Test for Right Move of the White Queen Figure.
     */
    @Test
    public void whenWhiteQueenRightWayThenWayContainsDest() {
        Cell source = Cell.D4;
        Cell dest = Cell.D1;
        QueenWhite queenWhite = new QueenWhite(source);
        Cell[] way = queenWhite.way(source, dest);
        assertThat(way[way.length - 1], is(dest));
        assertThat(way.length, is(3));
    }

    /**
     * Test for Wrong Move of the Black Knight Figure.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenBlackKnightWrongWayThenImpossibleMoveException() {
        KnightBlack knightBlack = new KnightBlack(Cell.C4);
        knightBlack.way(Cell.C4, Cell.C6);
    }

    /**
     * Test for Right Move of the Black Knight Figure.
     */
    @Test
    public void whenBlackKnightRightWayThenWayContainsDest() {
        Cell source = Cell.C4;
        Cell dest = Cell.B2;
        KnightBlack knightBlack = new KnightBlack(source);
        Cell[] way = knightBlack.way(source, dest);
        assertThat(way[way.length - 1], is(dest));
        assertThat(way.length, is(1));
    }

    /**
     * Test for Wrong Move of the White Knight Figure.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenWhiteKnightWrongWayThenImpossibleMoveException() {
        KnightWhite knightWhite = new KnightWhite(Cell.C4);
        knightWhite.way(Cell.C4, Cell.C5);
    }

    /**
     * Test for Right Move of the White Knight Figure.
     */
    @Test
    public void whenWhiteKnightRightWayThenWayContainsDest() {
        Cell source = Cell.C4;
        Cell dest = Cell.A5;
        KnightWhite knightWhite = new KnightWhite(source);
        Cell[] way = knightWhite.way(source, dest);
        assertThat(way[way.length - 1], is(dest));
        assertThat(way.length, is(1));
    }
}
