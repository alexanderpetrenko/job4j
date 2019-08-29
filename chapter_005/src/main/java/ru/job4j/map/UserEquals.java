package ru.job4j.map;

import java.util.Calendar;

/**
 * The {@code User} class saves information about the User.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 29.08.2019
 */
public class UserEquals {
    private String name;
    private int children;
    private Calendar birthday;

    public UserEquals(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEquals that = (UserEquals) o;
        return children == that.children
                && name.equals(that.name)
                && birthday.equals(that.birthday);
    }
}
