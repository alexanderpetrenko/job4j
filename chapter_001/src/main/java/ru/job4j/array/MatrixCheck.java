package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i-1][i-1] != data[i][i] &&
                    data[i-1][data.length-i] != data[i][data.length-1-i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
