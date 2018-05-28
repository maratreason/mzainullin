package ru.mzainullin.iterators.generics;

/**
 * @author Marat Zainullin
 * @since 26.05.2018
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    private Object[] userArray;
    private int position = 0;

    public AbstractStore(SimpleArray<T> arr) {
        new SimpleArray<T>(100);
    }

    /**
     * Метод для добавления модели
     * @param model - модель для добавления
     */
    @Override
    public void add(T model) {
        this.userArray[position++] = model;
    }

    /**
     * Метод для замены одной модели на другую
     * @param id - id модели для замены
     * @param model - новая модель.
     * @return - успешно заменили модель (true / false)
     */
    @Override
    public boolean replace(String id, T model) {
        for (int index = 0; index != this.userArray.length; index++) {
            if (id.equals(this.userArray[index])) {
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
            if (id.equals(this.userArray[index])) {
                Object[] tmp = new Object[this.userArray.length - 1];
                System.arraycopy(this.userArray, 0, tmp, 0, index);
                System.arraycopy(this.userArray, index + 1, tmp, index, this.userArray.length - index - 1);
                this.userArray = tmp;
            }
        }
        return true;
    }

    @Override
    public T findById(String id) {
        Object user = new Object();
        for (int index = 0; index != this.userArray.length; index++) {
            if (id.equals(this.userArray[index])) {
                user = this.userArray[index];
            }
        }
        return (T) user;
    }

    @Override
    public String toString() {
        return "AbstractStore{" +
                "position=" + position +
                '}';
    }
}
