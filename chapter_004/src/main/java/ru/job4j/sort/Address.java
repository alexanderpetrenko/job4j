package ru.job4j.sort;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private int home;
    private int flat;

    public Address(String city, String street, int home, int flat) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.flat = flat;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && flat == address.flat
                && city.equals(address.city)
                && street.equals(address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, flat);
    }
}
