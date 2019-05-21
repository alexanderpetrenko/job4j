package ru.job4j.generic;

/**
 * The {@code Role} class saves information about user's role.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 21.05.2019
 */
public class Role extends Base {
    private String job;

    protected Role(String id, String job) {
        super(id);
        this.job = job;
    }

    public String getJob() {
        return job;
    }
}
