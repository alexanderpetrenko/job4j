package ru.job4j.generic;

/**
 * The {@code User Store} class works like a container for all users,
 * who works for a project.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 21.05.2019
 */
public class UserStore extends AbstractStore<User> {
    public UserStore(int size) {
        super(size);
    }
}
