package ru.mzainullin.iterators.generics;

/**
 * @author Marat Zainullin
 * @since 26.05.2018
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> simpleArray;
    private int position = 0;

    public AbstractStore(SimpleArray<T> arr) {
        this.simpleArray = arr;
    }


    /**
     * Метод для добавления модели
     * @param model - модель для добавления
     */
    @Override
    public void add(T model) {
        this.simpleArray.add(model);
    }


    /**
     * Метод для замены одной модели на другую
     * @param id - id модели для замены
     * @param model - новая модель.
     * @return - успешно заменили модель (true / false)
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        for (int i = 0; i < simpleArray.size(); i++) {
            if (simpleArray.get(i).getId().equals(id)) {
                simpleArray.set(i, model);
                result = true;
                break;
            }
        }
        return result;
    }


    /**
     * Метод удаления модели
     * @param id - id удаляемой модели
     * @return - новый уменьшенный массив
     */
    @Override
    public boolean delete(String id) {
        T result = null;
        for (T tmp : simpleArray) {
            if (tmp.getId().equals(id)) {
                result = tmp;
            }
        }
        return true;
    }


    /**
     * Метод поиска объекта по его Id.
     * @param id - id объекта.
     * @return - индекс найденного объекта.
     */
    @Override
    public T findById(String id) {
        T result = null;
        for (T tmp : simpleArray) {
            if (tmp.getId().equals(id)) {
                result = tmp;
                break;
            }
        }
        return result;
    }

}
