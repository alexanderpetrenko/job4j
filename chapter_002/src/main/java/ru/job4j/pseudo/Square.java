package ru.job4j.pseudo;

/**
 * The {@code Square} class is an operation class
 * of the Strategy interface ({@code Shape} interface).
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class Square implements Shape {
    /**
     * This operation method draws a square in pseudographics.
     *
     * @return A square in the String type.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        String ls = System.lineSeparator();
        pic.append("++++").append(ls);
        pic.append("+  +").append(ls);
        pic.append("+  +").append(ls);
        pic.append("++++").append(ls);
        return pic.toString();
    }
}
