package ru.mzainullin.oop.start;

import org.junit.Test;
import ru.mzainullin.oop.models.Item;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    // @Test
    // public void whenAddNewItemThenTrackerHasSameItem() {
    //     Tracker tracker = new Tracker();
    //     Item item = new Item("test1","testDescription",123L);
    //     tracker.add(item);
    //     assertThat(tracker.findAll()[0], is(item));
    // }


    @Test
    public void whenReplaceNameThenReturnNewName() {

        Tracker tracker = new Tracker();

        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);


        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());


        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));


        // Найти все заявки в трекере.
        tracker.findAll();
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));


        // Найти заявку по имени в трекере.
        tracker.findByName(previous.getName());
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));


        // Удаляем заявку в трекере.
        tracker.delete(previous.getId());
        // is() ждет строку, поэтому пришлось добавить эту переменную
        String strNull = null;
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()), is(strNull));
    }

    @Test
    public void whenFindAllThenReturnAll() {
        Tracker tracker = new Tracker();

        Item previous = new Item("Задача", "Выучить Java", 555L);
        tracker.add(previous);

        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());

        // Найти все заявки в трекере.
        tracker.findAll();

        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findAll().toString(), is("Задача"));
    }
}
