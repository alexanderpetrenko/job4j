package ru.job4j.chess.figures.black;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.figure.Pawn;

/**
 * The {@code PawnBlack} class creates the Black Pawn Chess Figure.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 0.1
 */
public class PawnBlack extends Pawn {
    /**
     * The class constructor sets position of the Black Pawn on the board.
     *
     * @param position The cell on the chess board, where the Pawn stands.
     */
    public PawnBlack(final Cell position) {
        super(position);
    }

    /**
     * The method check the possibility of Black Pawn's moving
     * and returns final position of Cell of the Pawn way.
     *
     * @param source Start position of the Pawn.
     * @param dest   Final position of the Pawn.
     * @return An array with a final Cell position.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!(source.y == dest.y + 1 && source.x == dest.x)) {
            throw new ImpossibleMoveException("This move is impossible for the Pawn Figure");
        }
        return new Cell[]{dest};
    }

    /**
     * The method, which creates a copy of Pawn on the new position.
     *
     * @param dest The cell on the chess board, where the Pawn is moving.
     * @return A new Pawn Figure on a new Cell.
     */
    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
