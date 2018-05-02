package ru.mzainullin.search;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 02.05.2018
 */
public class Task {

    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
