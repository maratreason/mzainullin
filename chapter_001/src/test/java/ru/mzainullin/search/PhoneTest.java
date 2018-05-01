package ru.mzainullin.search;

import org.junit.Test;
        import java.util.List;
        import static org.hamcrest.core.Is.is;
        import static org.junit.Assert.assertThat;

public class PhoneTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("rya");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}