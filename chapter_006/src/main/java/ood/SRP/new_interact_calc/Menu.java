package ood.SRP.new_interact_calc;

import java.util.List;

/**
 * @author Marat Zainullin.
 * @version 0.1.
 * @since 24.02.2019.
 */
public interface Menu {

    /**
     * Текстовая инструкция при запуске.
     */
    void info();

    /**
     * Наполнение меню.
     */
    void fillMenu();

    /**
     * Показать меню.
     */
    void showMenu();
}
