package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.BishopBlack;
import ru.job4j.chess.figures.black.PawnBlack;
import ru.job4j.chess.figures.white.*;

/**
 * Tests for {@code Logic} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class LogicTest {
    /**
     * Test for Black Bishop moving on Occupied Cell.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenBlackBishopMoveOnOccupiedCellThenOccupiedWayException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F1);
        PawnBlack pawnBlack = new PawnBlack(Cell.G2);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        logic.move(Cell.F1, Cell.G2);
    }

    /**
     * Test for White Bishop moving on Occupied Cell.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenWhiteBishopMoveOnOccupiedCellThenOccupiedWayException() {
        BishopWhite bishopWhite = new BishopWhite(Cell.F1);
        PawnWhite pawnWhite = new PawnWhite(Cell.G2);
        Logic logic = new Logic();
        logic.add(bishopWhite);
        logic.add(pawnWhite);
        logic.move(Cell.F1, Cell.G2);
    }

    /**
     * Test for right moving of the Black Pawn.
     */
    @Test
    public void whenBlackPawnRightMoveThenNoException() {
        PawnBlack pawnBlack = new PawnBlack(Cell.E2);
        Logic logic = new Logic();
        logic.add(pawnBlack);
        logic.move(Cell.E2, Cell.E1);
    }

    /**
     * Test for right moving of the White Pawn.
     */
    @Test
    public void whenWhitePawnRightMoveThenNoException() {
        PawnWhite pawnWhite = new PawnWhite(Cell.E7);
        Logic logic = new Logic();
        logic.add(pawnWhite);
        logic.move(Cell.E7, Cell.E8);
    }

    /**
     * Test for White Pawn moving on Occupied Cell.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenWhitePawnMoveOnOccupiedCellThenOccupiedWayException() {
        PawnWhite pawnWhite = new PawnWhite(Cell.E6);
        PawnBlack pawnBlack = new PawnBlack(Cell.E7);
        Logic logic = new Logic();
        logic.add(pawnWhite);
        logic.add(pawnBlack);
        logic.move(Cell.E6, Cell.E7);
    }

    /**
     * Test for White King moving on Occupied Cell.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenWhiteKingMoveOnOccupiedCellThenOccupiedWayException() {
        KingWhite kingWhite = new KingWhite(Cell.E8);
        PawnBlack pawnBlack = new PawnBlack(Cell.E7);
        Logic logic = new Logic();
        logic.add(kingWhite);
        logic.add(pawnBlack);
        logic.move(Cell.E8, Cell.E7);
    }

    /**
     * Test for White Knight moving on Occupied Cell.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenWhiteKnightMoveOnOccupiedCellThenOccupiedWayException() {
        KnightWhite knightWhite = new KnightWhite(Cell.C4);
        PawnBlack pawnBlack = new PawnBlack(Cell.A5);
        Logic logic = new Logic();
        logic.add(knightWhite);
        logic.add(pawnBlack);
        logic.move(Cell.C4, Cell.A5);
    }

    /**
     * Test for White Queen moving on Occupied Cell.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenWhiteQueenMoveOnOccupiedCellThenOccupiedWayException() {
        QueenWhite queenWhite = new QueenWhite(Cell.E8);
        PawnBlack pawnBlack = new PawnBlack(Cell.D7);
        Logic logic = new Logic();
        logic.add(queenWhite);
        logic.add(pawnBlack);
        logic.move(Cell.E8, Cell.D7);
    }

    /**
     * Test for White Rook moving on Occupied Cell.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenWhiteRookMoveOnOccupiedCellThenOccupiedWayException() {
        RookWhite rookWhite = new RookWhite(Cell.A1);
        QueenWhite queenWhite = new QueenWhite(Cell.A2);
        Logic logic = new Logic();
        logic.add(rookWhite);
        logic.add(queenWhite);
        logic.move(Cell.A1, Cell.A2);
    }

    /**
     * Test for making move without a Figure (exception).
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenWhiteRookNotFoundOnCellThenFigureNotFoundException() {
        RookWhite rookWhite = new RookWhite(Cell.A1);
        Logic logic = new Logic();
        logic.add(rookWhite);
        logic.move(Cell.B1, Cell.B2);
    }
}
