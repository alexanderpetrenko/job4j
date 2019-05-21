package ru.job4j.generic;

/**
 * The {@code Role Store} class works like a container for all user's roles
 * in a project.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 21.05.2019
 */
public class RoleStore extends AbstractStore<Role> {
    public RoleStore(int size) {
        super(size);
    }
}
