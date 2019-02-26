package ru.job4j.chess.figures.figure;

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
}
