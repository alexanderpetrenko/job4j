package ru.job4j.chess.figures.figure;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public abstract class Rook implements Figure {
    protected final Cell position;

    public Rook(Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!(isHorizontal(source, dest) || isVertical(source, dest))) {
            throw new ImpossibleMoveException("This move is impossible for the Rook Figure");
        }
        Cell[] steps = new Cell[Math.abs(dest.x - source.x) + Math.abs(dest.y - source.y)];
        if (isHorizontal(source, dest)) {
            int deltaX = dest.x > source.x ? 1 : -1;
            for (int i = 0; i < steps.length; i++) {
                steps[i] = Cell.findByCoord(source.x + deltaX * (i + 1), source.y);
            }
        } else if (isVertical(source, dest)) {
            int deltaY = dest.y > source.y ? 1 : -1;
            for (int i = 0; i < steps.length; i++) {
                steps[i] = Cell.findByCoord(source.x, source.y + deltaY * (i + 1));
            }
        }
        return steps;
    }
}
