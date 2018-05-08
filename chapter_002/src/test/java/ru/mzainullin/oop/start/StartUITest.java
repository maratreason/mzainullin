package ru.mzainullin.oop.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mzainullin.oop.models.Item;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {


    // получаем ссылку на стандартный вывод в консоль.
    PrintStream stdout = System.out;
    // Создаем буфер для хранения вывода.
    ByteArrayOutputStream out = new ByteArrayOutputStream();


    @Before
    public void loadOutput() {
        System.out.println("before");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("after");
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameNameRef() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();
        Item item = tracker.add(new Item("first", "first desc"));

        assertThat(tracker.findById(item.getId()).getName(),
                is(new StringBuilder().append("first").toString())
        );
    }


    @Test
    public void whenEditAndReplaceCurrentItemRef() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("second name", "second desc"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[] {"2", item.getId(), "third name", "third desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

        assertThat(tracker.findById(item.getId()).getName(),
                is(new StringBuilder().append("third name").toString())
        );
    }


    @Test
    public void whenDeleteItemThenTrackerBecameOneLessRef() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем 2 заявки item и item1
        Item item = tracker.add(new Item("first name", "first desc"));
        Item item1 = tracker.add(new Item("second name", "second desc"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

        assertThat(tracker.findById(item1.getId()).getName(),
                is(new StringBuilder().append("second name").toString())
        );
    }


    @Test
    public void whenFindCurrentItemByItemIdRef() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем 2 заявки item и item1
        Item item = tracker.add(new Item());
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

        assertThat(tracker.findById(item.getId()).getId(),
                is(new StringBuilder().append(item.getId()).toString())
        );
    }


    @Test
    public void whenFindCurrentItemByItemNameRef() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем 2 заявки item и item1
        Item item = tracker.add(new Item("first name", "first desc"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"5", "first name", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

        assertThat(tracker.findById(item.getId()).getName(),
                is(new StringBuilder().append(item.getName()).toString())
        );
    }

}
