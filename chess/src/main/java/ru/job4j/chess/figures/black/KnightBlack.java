package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.figure.Knight;

/**
 * The {@code KnightBlack} class creates the Black Knight Chess Figure.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 0.1
 */
public class KnightBlack extends Knight {
    /**
     * The class constructor sets position of the Black Knight on the board.
     *
     * @param position The cell on the chess board, where the Knight stands.
     */
    public KnightBlack(final Cell position) {
        super(position);
    }

    /**
     * The method, which creates a copy of Knight on the new position.
     *
     * @param dest The cell on the chess board, where the Knight is moving.
     * @return A new Knight Figure on a new Cell.
     */
    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
