package ru.job4j.coffee;

public class CoffeeMachine {

    private int[] coins;

    public CoffeeMachine(int[] coins) {
        this.coins = coins;
//        Arrays.sort(this.coins);
    }

    public int[] changes(int value, int price) {
        int delta = value - price;
        if (delta < 0) {
            throw new NotEnoughMoney("You have not enough money for your order.");
        }
        int[] rst = new int[delta];
//        for (int coin : coins) {
//            delta
//        }
        return rst;
    }
}
