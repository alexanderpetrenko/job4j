package ru.job4j.loop;

/**
 * Object of the {@code Board} class used for
 * drawing chessboard.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Board {
    /**
     * This method can draw a chessboard in pseudographics.
     *
     * @param width  The width of a chessboard.
     * @param height The height of a chessboard.
     * @return The schematic representation of a chessboard
     * in a {@code String} type.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(' ');
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
