package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.figure.Bishop;

/**
 * The {@code BishopBlack} class creates the Black Bishop Chess Figure.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 0.1
 */
public class BishopBlack extends Bishop {
    /**
     * The class constructor sets position of the Black Bishop on the board.
     *
     * @param position The cell on the chess board, where the Bishop stands.
     */
    public BishopBlack(final Cell position) {
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
        return new BishopBlack(dest);
    }
}
