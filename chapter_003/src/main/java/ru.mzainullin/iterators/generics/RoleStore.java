package ru.mzainullin.iterators.generics;

/**
 * @author Marat Zainullin
 * @since 25.05.2018
 */
public class RoleStore<T extends Role> implements Store<T> {

    private Role[] roleArray;
    private int position = 0;

    public RoleStore(T[] arr) {
        this.roleArray = arr;
    }

    /**
     * Метод для добавления модели
     * @param model - модель для добавления
     */
    @Override
    public void add(T model) {
        this.roleArray[position++] = model;
    }

    /**
     * Метод для замены одной модели на другую
     * @param id - id модели для замены
     * @param model - новая модель.
     * @return - успешно заменили модель (true / false)
     */
    @Override
    public boolean replace(String id, T model) {
        for (int index = 0; index != this.roleArray.length; index++) {
            if (id.equals(this.roleArray[index].getId())) {
                this.roleArray[index] = model;
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
        for (int index = 0; index != this.roleArray.length; index++) {
            if (id.equals(this.roleArray[index].getId())) {
                Role[] tmp = new Role[this.roleArray.length - 1];
                System.arraycopy(this.roleArray, 0, tmp, 0, index);
                System.arraycopy(this.roleArray, index + 1, tmp, index, this.roleArray.length - index - 1);
                this.roleArray = tmp;
            }
        }
        return true;
    }

    @Override
    public T findById(String id) {
        Role role = new Role(id);
        for (int index = 0; index != this.roleArray.length; index++) {
            if (id.equals(this.roleArray[index].getId())) {
                role = this.roleArray[index];
            }
        }
        return (T) role;
    }
}

