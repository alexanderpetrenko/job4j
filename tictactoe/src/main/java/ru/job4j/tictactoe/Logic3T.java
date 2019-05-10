package ru.job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * The {@code Logic3T} class describes the logic of the TicTakToe game.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 10.05.2019
 */
public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * @param predicate Predicate Function for Figure X or Figure O.
     * @param startX    X Coordinate of Start Position.
     * @param startY    Y Coordinate of Start Position.
     * @param deltaX    Direction of changing X Coordinate.
     * @param deltaY    Direction of changing Y Coordinate.
     * @return true - if the column/row/diagonal is filled by the Figure X or The Figure O; otherwise - false;
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * The method checks if X won.
     *
     * @return true if X won; otherwise - false.
     */
    public boolean isWinnerX() {
        return this.isWinner(Figure3T::hasMarkX);
    }

    /**
     * The method checks if O won.
     *
     * @return true if O won; otherwise - false.
     */
    public boolean isWinnerO() {
        return this.isWinner(Figure3T::hasMarkO);
    }

    private boolean isWinner(Predicate<Figure3T> predicate) {
        boolean result = false;
        // Check diagonals.
        if (this.fillBy(predicate, 0, 0, 1, 1)
                || this.fillBy(predicate, this.table.length - 1, 0, -1, 1)) {
            result = true;
        } else { // Check horizontals and verticals.
            for (int i = 0; i != this.table.length; i++) {
                if (this.fillBy(predicate, 0, i, 1, 0)
                        || this.fillBy(predicate, i, 0, 0, 1)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * The method checks free fields.
     *
     * @return true - if there are free fields; otherwise - false.
     */
    public boolean hasGap() {
        int figuresCount = (int) Arrays.stream(this.table).flatMap(Arrays::stream)
                .filter(cell -> cell.hasMarkO() || cell.hasMarkX()).count();
        return this.table.length * this.table.length != figuresCount;
    }
}
