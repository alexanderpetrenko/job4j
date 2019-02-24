package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.BishopBlack;
import ru.job4j.chess.figures.black.PawnBlack;
import ru.job4j.chess.figures.white.BishopWhite;
import ru.job4j.chess.figures.white.PawnWhite;

/**
 * Test for {@code Logic} class.
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
}
