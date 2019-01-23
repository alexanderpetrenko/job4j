package ru.job4j.loop;

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
        // Buffer for result
        StringBuilder screen = new StringBuilder();
        // Weight equals height
        int weight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
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
        StringBuilder screen = new StringBuilder();
        int weight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= weight - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * This method allows you to draw a full pyramid.
     *
     * @param height The height of a pyramid.
     * @return The schematic representation of a pyramid
     * as a triangle in a {@code String} type.
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
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
