package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

/**
 * The {@code User} class saves information about the User.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 29.08.2019
 */
public class UserHashCode {
    private String name;
    private int children;
    private Calendar birthday;

    public UserHashCode(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
