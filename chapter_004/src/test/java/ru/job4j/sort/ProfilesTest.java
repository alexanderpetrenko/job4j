package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The testing class for the {@code Profiles} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 16.04.2019
 */
public class ProfilesTest {
    @Test
    public void whenProfilesListThenAddressList() {
        List<Profile> customers = new ArrayList<>(
                Arrays.asList(
                        new Profile(new Address("London", "Baker street", 221, 1)),
                        new Profile(new Address("London", "Baker street", 221, 1)),
                        new Profile(new Address("Moscow", "Stroiteley", 25, 12)),
                        new Profile(new Address("Moscow", "Stroiteley", 25, 12)),
                        new Profile(new Address("Leningrad", "Stroiteley", 25, 12))
                )
        );
        List<Address> expected = new ArrayList<>(
                Arrays.asList(
                        new Address("London", "Baker street", 221, 1),
                        new Address("London", "Baker street", 221, 1),
                        new Address("Moscow", "Stroiteley", 25, 12),
                        new Address("Moscow", "Stroiteley", 25, 12),
                        new Address("Leningrad", "Stroiteley", 25, 12)
                )
        );
        Profiles profiles = new Profiles();
        assertThat(profiles.collect(customers), is(expected));
    }

    @Test
    public void whenProfilesListThenUniqueAddressList() {
        List<Profile> customers = new ArrayList<>(
                Arrays.asList(
                        new Profile(new Address("London", "Baker street", 221, 1)),
                        new Profile(new Address("London", "Baker street", 221, 1)),
                        new Profile(new Address("Moscow", "Stroiteley", 25, 12)),
                        new Profile(new Address("Moscow", "Stroiteley", 25, 12)),
                        new Profile(new Address("Leningrad", "Stroiteley", 25, 12))
                )
        );
        List<Address> expected = new ArrayList<>(
                Arrays.asList(
                        new Address("Leningrad", "Stroiteley", 25, 12),
                        new Address("London", "Baker street", 221, 1),
                        new Address("Moscow", "Stroiteley", 25, 12)
                )
        );
        Profiles profiles = new Profiles();
        assertThat(profiles.unique(customers), is(expected));
    }
}
