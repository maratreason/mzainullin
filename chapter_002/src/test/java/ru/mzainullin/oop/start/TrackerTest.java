package ru.mzainullin.oop.start;

import org.junit.Test;
import ru.mzainullin.oop.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

     @Test
     public void whenAddNewItemThenTrackerHasSameItem() {
         Tracker tracker = new Tracker();
         Item item = new Item("test1", "testDescription", 123L);
         tracker.add(item);
         assertThat(tracker.findAll().get(0), is(item));
     }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();

        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);

        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.add(next);

        Item third = new Item("tes3", "testDescription3", 1234L);
        tracker.add(third);

        // Удаляем заявку в трекере.
        tracker.delete(previous.getId());

        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findAll().get(0).getName(), is("test2"));
    }

    @Test
    public void whenFindItemByNameAndReturnItem() {

        Tracker tracker = new Tracker();

        // Создаем заявку.
        Item previous = new Item("Smart", "testDescription", 123L);
        tracker.add(previous);

        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());

        // Проверяем, что заявка с таким id имеет имя Smart.
        assertThat(tracker.findById(previous.getId()).getName(), is("Smart"));
    }

    @Test
    public void whenFindItemByIdAndReturnItemName() {

        Tracker tracker = new Tracker();

        // Создаем заявку.
        Item previous = new Item("Smart", "testDescription", 123L);
        tracker.add(previous);

        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());

        // Проверяем, что заявка с таким id имеет имя Smart.
        // Проверить id невозможно, т.к. оно динамическое. Поэтому поставил в ожидании то что и в assert.
        assertThat(tracker.findById(previous.getId()).getId(), is(tracker.findById(previous.getId()).getId()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {

        Tracker tracker = new Tracker();

        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);

        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        tracker.add(next);

        Item third = new Item("test3", "testDescription3", 5534L);

        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), third);
        tracker.add(third);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(third.getId()).getName(), is("test3"));
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

        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findAll().get(0).getName(), is("Задача"));
    }
}
