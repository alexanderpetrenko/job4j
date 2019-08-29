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
public class UserEqualsHash {
    private String name;
    private int children;
    private Calendar birthday;

    public UserEqualsHash(String name, int children, Calendar birthday) {
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
        UserEqualsHash that = (UserEqualsHash) o;
        return children == that.children
                && name.equals(that.name)
                && birthday.equals(that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
