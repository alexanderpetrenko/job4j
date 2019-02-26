package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.figure.King;

/**
 * The {@code KingBlack} class creates the Black King Chess Figure.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 0.1
 */
public class KingBlack extends King {
    /**
     * The class constructor sets position of the Black King on the board.
     *
     * @param position The cell on the chess board, where the King stands.
     */
    public KingBlack(final Cell position) {
        super(position);
    }

    /**
     * The method, which creates a copy of King on the new position.
     *
     * @param dest The cell on the chess board, where the King is moving.
     * @return A new King Figure on a new Cell.
     */
    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}
