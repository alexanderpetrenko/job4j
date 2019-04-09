package ru.job4j.department;

import java.util.*;

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
    public Set<String> sortAsc(List<String> codes) {
        Set<String> result = new TreeSet<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                }
        );
        for (String code : codes) {
            result.addAll(addAbsent(code));
        }
        return result;
    }

    /**
     * The method provides descending sorting operation.
     *
     * @param codes Input Array of department codes.
     * @return Sorted Array of department codes.
     */
    public Set<String> sortDesc(List<String> codes) {
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
            result.addAll(addAbsent(code));
        }
        return result;
    }

    /**
     * The method returns List of Department's Names,
     *
     * @param dep Input String with the Department's Name.
     * @return List of Department's Names.
     */
    List<String> addAbsent(String dep) {
        List<String> result = new LinkedList<>();
        String[] depNames = dep.split("\\\\");
        StringBuilder department = new StringBuilder();
        for (String depName : depNames) {
            department.append(depName);
            result.add(department.toString());
            department.append("\\");
        }
        return result;
    }
}
