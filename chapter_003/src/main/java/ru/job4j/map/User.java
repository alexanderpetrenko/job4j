package ru.job4j.map;

import java.util.Objects;

/**
 * The {@code User} class saves an information about user.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 04.03.2019
 */
public class User {
    private int id;
    private String name;
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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
        User user = (User) o;
        return id == user.id
                && name.equals(user.name)
                && city.equals(user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }
}
