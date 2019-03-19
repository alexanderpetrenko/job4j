package ru.job4j.sort;

/**
 * The {@code User} class saves an information about user.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 19.03.2019
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        int rsl = this.age - o.age;
        return rsl != 0 ? rsl : this.name.compareTo(o.name);
    }
}
