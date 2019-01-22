package ru.job4j.calculator;

/**
 * The program for calculating
 * the ideal human's weight.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class Fit {

    /**
     * The ideal weight for man.
     *
     * @param height Man's height.
     * @return Ideal weight.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * The ideal weight for women.
     *
     * @param height Woman's height.
     * @return Ideal weight.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
