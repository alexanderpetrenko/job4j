package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code PhoneDictionary} class describes a phonebook.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class PhoneDictionary {
    /**
     * List of people in the phonebook.
     */
    private List<Person> persons = new ArrayList<>();

    /**
     * The method provides adding a new Person to a phonebook.
     *
     * @param person Item of Person.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * The method provides search of a Person in the List of people from the phonebook.
     *
     * @param key Searching field (name, surname, phone number or address of a Person.
     * @return List of people, that meet the search criteria.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        if (key != null) {
            for (Person person : this.persons) {
                if (person.getName().contains(key)
                        || person.getSurname().contains(key)
                        || person.getPhone().contains(key)
                        || person.getAddress().contains(key)) {
                    result.add(person);
                }
            }
        }
        return result;
    }
}
