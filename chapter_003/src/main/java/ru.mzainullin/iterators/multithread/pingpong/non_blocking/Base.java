package ru.mzainullin.iterators.multithread.pingpong.non_blocking;

import java.util.concurrent.ConcurrentHashMap;

public class Base {
    private int id;
    private volatile int version = 1;

    private ConcurrentHashMap<Integer, Base> base = new ConcurrentHashMap<>();

    public Base(int id) {
        this.id = id;
    }


    private int getCurrentVersion() {
        return this.version;
    }

    public synchronized int getId() {
        return id;
    }

    public synchronized void setId(int id) {
        this.id = id;
    }


    public void add(Base model) {
        if (this.version != getCurrentVersion()) {
            this.base.put(model.getId(), model);
            this.version++;
        } else {
            throw new OptimisticException();
        }
    }


    public void update(Base model) {
        for (int i = 0; i < this.base.size(); i++) {
            if (this.base.get(i).equals(model)) {
                if (this.version != getCurrentVersion()) {
                    this.base.replace(this.base.get(i).getId(), model);
                    this.version++;
                } else {
                    throw new OptimisticException();
                }
            }
        }
    }


    public void delete(Base model) {
        if (this.version != getCurrentVersion()) {
            this.base.remove(model.getId());
            this.version++;
        } else {
            throw new OptimisticException();
        }
    }


    public ConcurrentHashMap<Integer, Base> getCollection() {
        return this.base;
    }

}
