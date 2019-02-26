package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.figure.Rook;

/**
 * The {@code RookBlack} class creates the Black Rook Chess Figure.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 0.1
 */
public class RookBlack extends Rook {
    /**
     * The class constructor sets position of the Black Rook on the board.
     *
     * @param position The cell on the chess board, where the Rook stands.
     */
    public RookBlack(final Cell position) {
        super(position);
    }

    /**
     * The method, which creates a copy of Rook on the new position.
     *
     * @param dest The cell on the chess board, where the Rook is moving.
     * @return A new Rook Figure on a new Cell.
     */
    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
