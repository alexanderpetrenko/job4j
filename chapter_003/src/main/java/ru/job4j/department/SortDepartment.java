package ru.job4j.department;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * The {@code SortDepartment} class provides sorting operations.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 30.03.2019
 */
public class SortDepartment {
    /**
     * The method provides ascending sorting operation.
     *
     * @param codes Input Array of department codes.
     * @return Sorted Array of department codes.
     */
    public String[] sortAscending(String[] codes) {
        Set<String> result = new TreeSet<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                }
        );
        for (String code : codes) {
            String[] departmentNames = code.split("\\\\");
            StringBuilder department = new StringBuilder();
            for (String departmentName : departmentNames) {
                department.append(departmentName);
                result.add(department.toString());
                department.append("\\");
            }
        }
        return result.toArray(new String[0]);
    }

    /**
     * The method provides descending sorting operation.
     *
     * @param codes Input Array of department codes.
     * @return Sorted Array of department codes.
     */
    public String[] sortDescending(String[] codes) {
        Set<String> result = new TreeSet<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int lim = Math.min(o1.length(), o2.length());
                        int k = 0;
                        while (k < lim) {
                            if (o2.toCharArray()[k] != o1.toCharArray()[k]) {
                                return o2.toCharArray()[k] - o1.toCharArray()[k];
                            }
                            k++;
                        }
                        return o1.length() - o2.length();
                    }
                }
        );
        for (String code : codes) {
            String[] departmentNames = code.split("\\\\");
            StringBuilder department = new StringBuilder();
            for (String departmentName : departmentNames) {
                department.append(departmentName);
                result.add(department.toString());
                department.append("\\");
            }
        }
        return result.toArray(new String[0]);
    }
}
