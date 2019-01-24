package ru.job4j.array;

/**
 * An object of the {@code ArrayCheck} class checks
 * it the word starts with the specified prefix.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayChar {
    /**
     * The word as an array of characters.
     */
    private char[] data;

    /**
     * The class constructor converts a word to
     * an array of chars.
     *
     * @param line The word.
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Tests if the word starts with the specified prefix.
     *
     * @param prefix the prefix.
     * @return {@code true} if the character sequence represented by the
     * argument is a beginning of the word; {@code false} otherwise.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (this.data[i] != value[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
