package ru.job4j.chess.figures.figure;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public abstract class King implements Figure {
    protected final Cell position;

    public King(Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (Math.abs(deltaX) > 1 || Math.abs(deltaY) > 1) {
            throw new ImpossibleMoveException("This move is impossible for the King Figure");
        }
        return new Cell[]{dest};
    }
}
