package ru.job4j.comparator;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * The {@code StringsCompare} class compares two Strings.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class StringsCompare implements Comparator<String> {
    /**
     * The method compares two Strings.
     *
     * @param o1 The first String.
     * @param o2 The second String.
     * @return 0 - when Strings are equal;
     * 1 - when the first String is lexicographically greater;
     * -1 - when the second String is lexicographically greater.
     */
    @Override
    public int compare(String o1, String o2) {
        return IntStream.range(0, Math.min(o1.length(), o2.length()))
                .map(i -> Character.compare(o1.charAt(i), o2.charAt(i)))
                .filter(i -> i != 0)
                .findFirst()
                .orElse(o1.length() - o2.length());
    }
}
