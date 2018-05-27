package ru.mzainullin.iterators.generics;

/**
 * @author Marat Zainullin
 * @since 25.05.2018
 */
public class UserStore<T extends User> implements Store<User> {

    private User[] userArray;
    private int position = 0;

    public UserStore(T[] arr) {
        this.userArray = arr;
    }

    /**
     * Метод для добавления модели
     * @param model - модель для добавления
     */
    @Override
    public void add(User model) {
        this.userArray[position++] = model;
    }

    /**
     * Метод для замены одной модели на другую
     * @param id - id модели для замены
     * @param model - новая модель.
     * @return - успешно заменили модель (true / false)
     */
    @Override
    public boolean replace(String id, User model) {
        for (int index = 0; index != this.userArray.length; index++) {
            if (id.equals(this.userArray[index].getId())) {
                this.userArray[index] = model;
            }
        }
        return true;
    }

    /**
     * Метод удаления модели
     * @param id - id удаляемой модели
     * @return - новый уменьшенный массив
     */
    @Override
    public boolean delete(String id) {
        for (int index = 0; index != this.userArray.length; index++) {
            if (id.equals(this.userArray[index].getId())) {
                User[] tmp = new User[this.userArray.length - 1];
                System.arraycopy(this.userArray, 0, tmp, 0, index);
                System.arraycopy(this.userArray, index + 1, tmp, index, this.userArray.length - index - 1);
                this.userArray = tmp;
            }
        }
        return true;
    }

    @Override
    public User findById(String id) {
        User user = new User(id);
        for (int index = 0; index != this.userArray.length; index++) {
            if (id.equals(this.userArray[index].getId())) {
                user = this.userArray[index];
            }
        }
        return user;
    }
}