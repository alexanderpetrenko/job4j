package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * The {@code Calculator} class calculates mathematical functions.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 03.04.2019
 */
public class Calculator {
    /**
     * The method calculates mathematical functions in a range.
     *
     * @param start Value of range start.
     * @param end   Value of the end of the range.
     * @param func  Mathematical function for calculation.
     * @return List of values of calculated function.
     */
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index != end; index++) {
            result.add(func.apply((double) index));
        }
        return result;
    }
}
