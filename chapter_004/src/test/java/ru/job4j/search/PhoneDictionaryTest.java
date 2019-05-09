package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code PhoneDictionary} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 09.04.2019
 */
public class PhoneDictionaryTest {
    /**
     * Test for searching by Name of the Person.
     */
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * Test for searching by Phone Number of the Person.
     */
    @Test
    public void whenFindByPhone() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("James", "Bond", "007", "London")
        );
        var persons = phones.find("007");
        assertThat(persons.iterator().next().getAddress(), is("London"));
    }
}
