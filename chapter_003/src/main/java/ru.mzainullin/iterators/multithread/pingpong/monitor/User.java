package ru.mzainullin.iterators.multithread.pingpong.monitor;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 10.07.2018
 */
@ThreadSafe
public class User {

    private int id;

    /**
     * Сумма денег на счете пользователя.
     */
    @GuardedBy("this")
    private int amount;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}