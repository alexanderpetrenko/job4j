package ru.job4j.bank;

/**
 * The {@code Account} class saves an information about User's Banking Account.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 08.05.2019
 */
public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public boolean transfer(Account receiver, double amount) {
        boolean success = false;
        if (receiver != null && amount > 0 && amount <= this.value) {
            this.value -= amount;
            receiver.value += amount;
            success = true;
        }
        return success;
    }
}
