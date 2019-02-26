package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.figure.Knight;

/**
 * The {@code KnightWhite} class creates the White Knight Chess Figure.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 0.1
 */
public class KnightWhite extends Knight {
    /**
     * The class constructor sets position of the White Knight on the board.
     *
     * @param position The cell on the chess board, where the Knight stands.
     */
    public KnightWhite(final Cell position) {
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
        return new KnightWhite(dest);
    }
}
