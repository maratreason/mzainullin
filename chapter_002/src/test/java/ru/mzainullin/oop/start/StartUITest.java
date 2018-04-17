package ru.mzainullin.oop.start;

import org.junit.Test;
import ru.mzainullin.oop.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenUserChooseShowAllItems() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = tracker.add(new Item("first", "first desc"));
        Item item1 = tracker.add(new Item("second", "second desc"));

        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("first"));
        assertThat(tracker.findAll()[1].getName(), is("second"));
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }


    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"1", item.getId(), "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }


    @Test
    public void whenEditAndReplaceCurrentItem() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item( "second name", "second desc"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getName(), "third name", "third desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("third name"));
    }


    @Test
    public void whenDeleteItemThenTrackerBecameOneLess() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем 2 заявки item и item1
        Item item = tracker.add(new Item( "first name", "first desc"));
        Item item1 = tracker.add(new Item( "second name", "second desc"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

//        String deletedItem = null;
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
//        assertThat(tracker.findById(item.getId()), is(deletedItem));
        assertThat(tracker.findById(item1.getId()).getName(), is("second name"));
    }


    @Test
    public void whenFindCurrentItemByItemName() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем 2 заявки item и item1
        Item item = tracker.add(new Item());
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"5", "test name", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }


    @Test
    public void whenFindCurrentItemByItemId() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем 2 заявки item и item1
        Item item = tracker.add(new Item());
        item.setId("14365896794");
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"4", "14365896794", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getId(), is("14365896794"));
    }

}
