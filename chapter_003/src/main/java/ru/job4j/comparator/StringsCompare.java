package ru.job4j.comparator;

import java.util.Comparator;

/**
 * The {@code StringsCompare} class compares two Strings.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 20.03.2019
 */
public class StringsCompare implements Comparator<String> {
    /**
     * The method compares two Strings.
     *
     * @param o1 The first String.
     * @param o2 The second String.
     * @return  0 - when Strings are equal;
     *          1 - when the first String is lexicographically greater;
     *          -1 - when the second String is lexicographically greater.
     */
    @Override
    public int compare(String o1, String o2) {
        int minLength = o1.length() <= o2.length() ? o1.length() : o2.length();
        int result = 0;
        for (int i = 0; i < minLength; i++) {
            result = Character.compare(o1.charAt(i), o2.charAt(i));
            if (result != 0) {
                break;
            }
        }
        result = result != 0 ? result : o1.length() - o2.length();
        return result;
    }
}
