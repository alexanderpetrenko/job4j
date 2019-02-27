package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int i = 0;
//        Iterator<Integer> iter = list.iterator();
        for (int[] row : array) {
            for (int cell : row) {
                cell = i < list.size() ? list.get(i++) : 0;
//                if (iter.hasNext()) {
//                    cell = iter.next().intValue();
//                }
            }
        }
        return array;
    }
}
