package ru.mzainullin.search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {

    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();

        for(Person person : persons) {
            if (person.getName().contains(key) || person.getSurname().contains(key) ||
                person.getPhone().contains(key) || person.getAddress().contains(key)) {
                result = persons;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        PhoneDictionary phone = new PhoneDictionary();

        List<Person> person = new ArrayList<>();
        person.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        person.add(new Person("Alisa", "Rina", "111221", "Moscow"));

        for (Person elem : person) {
            System.out.println(
                    String.format(
                            "%s, %s, %s, %s", elem.getName(), elem.getSurname(), elem.getPhone(), elem.getAddress()
                    )
            );
        }
        System.out.println();
    }
}
