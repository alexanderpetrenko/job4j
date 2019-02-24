package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.figure.Bishop;

/**
 * The {@code BishopWhite} class creates the White Bishop Chess Figure.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 0.1
 */
public class BishopWhite extends Bishop {
    /**
     * The class constructor sets position of the White Bishop on the board.
     *
     * @param position The cell on the chess board, where the Bishop stands.
     */
    public BishopWhite(final Cell position) {
        super(position);
    }

    /**
     * The method, which creates a copy of Bishop to a new position.
     *
     * @param dest The cell on the chess board, where the Bishop is moving.
     * @return A new Bishop Figure on a new Cell.
     */
    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
