package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.figure.Rook;

/**
 * The {@code RookWhite} class creates the White Rook Chess Figure.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 0.1
 */
public class RookWhite extends Rook {
    /**
     * The class constructor sets position of the White Rook on the board.
     *
     * @param position The cell on the chess board, where the Rook stands.
     */
    public RookWhite(final Cell position) {
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
        return new RookWhite(dest);
    }
}
