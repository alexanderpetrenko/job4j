package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code Profiles} class returns customer's information from their profiles.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 16.04.2019
 */
public class Profiles {
    /**
     * The method returns customer's addresses.
     *
     * @param profiles List of customer's profiles.
     * @return List of customer's addresses.
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress).collect(Collectors.toList());
    }

    /**
     * The method returns unique customer's addresses.
     *
     * @param profiles List of customer's profiles.
     * @return List of unique customer's addresses.
     */
    public List<Address> unique(List<Profile> profiles) {
        return this.collect(profiles).stream()
                .sorted(Comparator.comparing(Address::getCity))
                .distinct().collect(Collectors.toList());
    }
}
