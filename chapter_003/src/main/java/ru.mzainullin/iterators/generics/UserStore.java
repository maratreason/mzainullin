package ru.mzainullin.iterators.generics;

/**
 * @author Marat Zainullin
 * @since 25.05.2018
 */
public class UserStore<T extends User> implements Store<T> {

    private T[] userArray;

    public UserStore(T[] arr) {
        this.userArray = arr;
    }

    @Override
    public void add(T model) {

    }

    @Override
    public boolean replace(String id, T model) {
        for (int index = 0; index != this.userArray.length; index++) {
            if (id.equals(this.userArray[index])) {
                this.userArray[index] = model;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public T findById(String id) {
        return null;
    }
}
