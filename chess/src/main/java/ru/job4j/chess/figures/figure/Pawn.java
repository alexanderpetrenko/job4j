package ru.job4j.chess.figures.figure;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public abstract class Pawn implements Figure {
    protected final Cell position;

    public Pawn(Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (source.y == dest.y + 1 && source.x == dest.x) {
            return new Cell[]{dest};
        } else {
            throw new ImpossibleMoveException("This move is impossible for the Pawn Figure");
        }
    }
}
