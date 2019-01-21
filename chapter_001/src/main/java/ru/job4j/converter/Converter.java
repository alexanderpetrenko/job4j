package ru.job4j.converter;

/**
 * Currency Converter.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 */
public class Converter {
    /**
     * The Euro exchange rate.
     */
    protected int euroRate = 70;

    /**
     * The Dollar exchange rate.
     */
    protected int dollarRate = 60;

    /**
     * Convert Ruble to Euros.
     * @param value Ruble.
     * @return Euros.
     */
    public int rubleToEuro(int value) {
        return value / this.euroRate;
    }

    /**
     * Convert Ruble to Dollars.
     * @param value Ruble.
     * @return Dollars.
     */
    public int rubleToDollar(int value) {
        return value / this.dollarRate;
    }


    /**
     * Convert Dollars to Ruble.
     * @param value Dollars.
     * @return Ruble.
     */
    public int dollarToRuble(int value) {
        return value * this.dollarRate;
    }

    /**
     * Convert Euros to Ruble.
     * @param value Euros.
     * @return Ruble.
     */
    public int euroToRuble(int value) {
        return value * this.euroRate;
    }
}