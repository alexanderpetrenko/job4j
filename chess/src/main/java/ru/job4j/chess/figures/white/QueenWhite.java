package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.figure.Queen;

/**
 * The {@code QueenWhite} class creates the White Queen Chess Figure.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 0.1
 */
public class QueenWhite extends Queen {
    /**
     * The class constructor sets position of the White Queen on the board.
     *
     * @param position The cell on the chess board, where the Queen stands.
     */
    public QueenWhite(final Cell position) {
        super(position);
    }

    /**
     * The method, which creates a copy of Queen on the new position.
     *
     * @param dest The cell on the chess board, where the Queen is moving.
     * @return A new Queen Figure on a new Cell.
     */
    @Override
    public Figure copy(Cell dest) {
        return new QueenWhite(dest);
    }
}
