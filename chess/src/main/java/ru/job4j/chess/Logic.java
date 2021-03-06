package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * The {@code Logic} class describes the logic of the chess game.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("Figure was not found");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        if (isOccupied(steps)) {
            throw new OccupiedWayException("There is an another figure on the way");
        }
        if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
            rst = true;
            this.figures[index] = this.figures[index].copy(dest);
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        return IntStream.range(0, figures.length)
                .filter(i -> figures[i] != null && figures[i].position().equals(cell))
                .findFirst().orElse(-1);
//        int rst = -1;
//        for (int index = 0; index != this.figures.length; index++) {
//            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
//                rst = index;
//                break;
//            }
//        }
//        return rst;
    }

    private boolean isOccupied(Cell[] steps) {
        return Arrays.stream(steps)
                .map(step -> this.findBy(step) != -1).findAny().orElse(false);
//        boolean rst = false;
//        for (Cell step : steps) {
//            if (this.findBy(step) != -1) {
//                rst = true;
//                break;
//            }
//        }
//        return rst;
    }
}
