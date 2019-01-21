package ru.job4j.calculator;

/**
 * The {@code Calculator} class used to produce
 * calculation of arithmetic operations:
 * addition (+), subtraction (-), multiplication (*)
 * and division (/).
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 */
public class Calculator {
    /**
     * Contains a result of operation.
     */
    private double result;

    /**
     * Addition Operation.
     * @param first First addend
     * @param second Second addend
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Subtraction operation.
     * @param first Minuend
     * @param second Subtrahend
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Division operation.
     * @param first Dividend
     * @param second Divisor
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Multiplication operation.
     * @param first First multiplier
     * @param second Second multiplier
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method for getting the result of operations.
     * @return Result
     */
    public double getResult() {
        return this.result;
    }
}