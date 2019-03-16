package ru.job4j.coffee;

import java.util.Arrays;

/**
 * The {@code CoffeeMachine} class calculates change for the coffee.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 16.03.2019
 */
public class CoffeeMachine {
    /**
     * Array of coins for change.
     */
    private int[] coins;

    /**
     * The class constructor initialises array of coins for change.
     *
     * @param coins Array of coins, that are available for change.
     */
    public CoffeeMachine(int[] coins) {
        this.coins = CoffeeMachine.descSort(coins);
    }

    /**
     * The method for descending sort of the array of coins.
     * The method uses Bubble Sort algorithm.
     *
     * @param array The array of coins for change.
     * @return The array of coins sorted in descending order.
     */
    private static int[] descSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    /**
     * The method counts the customer's change for coffee.
     * @param value The customers money for the coffee.
     * @param price The coffee price.
     * @return Array of coins for change.
     * @throws NotEnoughMoney - exception, when customer has not enough money for the coffee.
     */
    public int[] changes(int value, int price) {
        int delta = value - price;
        if (delta < 0) {
            throw new NotEnoughMoney("You have not enough money for your order.");
        }
        int[] result = new int[delta];
        int position = 0;
        if (delta == 0) {
            position++;
        } else {
            for (int coin : coins) {
                while (delta != 0) {
                    if (delta - coin >= 0) {
                        delta -= coin;
                        result[position++] = coin;
                    } else {
                        break;
                    }
                }
            }
        }
        return Arrays.copyOf(result, position);
    }
}
