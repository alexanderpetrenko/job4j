package ru.job4j.department;

import java.util.Objects;

public class Department implements Comparable<Department> {
    private String code;

    public Department(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public int compareTo(Department o) {
        return this.getCode().compareTo(o.getCode());
    }
}
