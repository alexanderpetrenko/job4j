package ru.job4j.chess.figures.figure;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public abstract class Queen implements Figure {
    private final Cell position;

    public Queen(Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!(isHorizontal(source, dest) || isVertical(source, dest) || isDiagonal(source, dest))) {
            throw new ImpossibleMoveException("This move is impossible for the Queen Figure");
        }
        Cell[] steps = null;
        if (isHorizontal(source, dest)) {
            steps = new Cell[Math.abs(dest.x - source.x)];
            int deltaX = dest.x > source.x ? 1 : -1;
            for (int i = 0; i < steps.length; i++) {
                steps[i] = Cell.findByCoord(source.x + deltaX * (i + 1), source.y);
            }
        } else if (isVertical(source, dest)) {
            steps = new Cell[Math.abs(dest.y - source.y)];
            int deltaY = dest.y > source.y ? 1 : -1;
            for (int i = 0; i < steps.length; i++) {
                steps[i] = Cell.findByCoord(source.x, source.y + deltaY * (i + 1));
            }
        } else if (isDiagonal(source, dest)) {
            steps = new Cell[Math.abs(dest.x - source.x)];
            int deltaX = dest.x > source.x ? 1 : -1;
            int deltaY = dest.y > source.y ? 1 : -1;
            for (int i = 0; i < steps.length; i++) {
                steps[i] = Cell.findByCoord(source.x + deltaX * (i + 1), source.y + deltaY * (i + 1));
            }
        }
        return steps;
    }
}
