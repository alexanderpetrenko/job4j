package ru.job4j.department;

import java.util.Set;
import java.util.TreeSet;

public class SortDepartment {
    public Set<Department> sortAscending(String[] codes) {
        Set<Department> result = new TreeSet<>();
        for (String code : codes) {
            Department mainDepartment = new Department(code.split("\\\\")[0]);
            if (!result.contains(mainDepartment)) {
                result.add(mainDepartment);
            }
            result.add(new Department(code));
        }
        return result;
    }

    public Set<Department> sortDescending(String[] codes) {
        return new TreeSet<Department>(this.sortAscending(codes)).descendingSet();
    }


    public static void main(String[] args) {
        String[] codes = new String[] {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        SortDepartment departments = new SortDepartment();
        Set<Department> result = departments.sortAscending(codes);
        for (Department department : result) {
            System.out.println(department.getCode());
        }
        System.out.println(" ");
        Set<Department> result1 = departments.sortDescending(codes);
        for (Department department : result1) {
            System.out.println(department.getCode());
        }
    }
}
