package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * The {@code Paint} class is used for drawing a pyramid.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * This method allows you to draw
     * the right half of the pyramid.
     *
     * @param height The height of a pyramid.
     * @return The schematic representation of the right pyramid side
     * as a triangle in a {@code String} type.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * This method allows you to draw
     * the left half of the pyramid.
     *
     * @param height The height of a pyramid.
     * @return The schematic representation of the left pyramid side
     * as a triangle in a {@code String} type.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * This method allows you to draw a full pyramid.
     *
     * @param height The height of a pyramid.
     * @return The schematic representation of a pyramid
     * as a triangle in a {@code String} type.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * @param height  The height of a pyramid.
     * @param weight  The weight of a pyramid.
     * @param predict The tick condition.
     * @return The schematic representation of a pyramid
     * as a triangle in a {@code String} type.
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
