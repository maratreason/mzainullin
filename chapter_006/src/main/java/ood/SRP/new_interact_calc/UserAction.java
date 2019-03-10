package ood.SRP.new_interact_calc;

/**
 * @author Marat Zainullin.
 * @version 0.1.
 * @since 24.02.2019.
 */
public class UserAction implements Action {

    /**
     * Ввод пользовательских данных.
     * @param number - ключ.
     * @param range - массив пунктов меню.
     * @return - выбранный ключ.
     */
    @Override
    public int ask(int number, int[] range) {
        int key = number;
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        return key;
    }

}
