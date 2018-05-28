package ru.mzainullin.iterators.generics;

/**
 * @author Marat Zainullin
 * @since 25.05.2018
 */
public class UserStore extends AbstractStore<User> {
    public UserStore(SimpleArray<User> simpleArray) {
        super(simpleArray);
    }
}
