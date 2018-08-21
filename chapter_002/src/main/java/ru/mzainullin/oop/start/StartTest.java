package ru.mzainullin.oop.start;

public class StartTest {
    public static void main(String[] args) {
        Input input = new StubInput(new String[] {"Create stub task"});
        new StartUI(input, new Tracker()).init();
    }
}