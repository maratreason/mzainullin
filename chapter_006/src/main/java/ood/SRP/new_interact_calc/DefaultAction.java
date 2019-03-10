package ood.SRP.new_interact_calc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marat Zainullin.
 * @version 0.1.
 * @since 24.02.2019.
 */
public class DefaultAction implements Menu {

    protected List<String> menu = new ArrayList<>();

    /**
     * Текстовая инструкция при запуске.
     */
    @Override
    public void info() {
        System.out.println("Выберете один из пунктов (0-5):");
        System.out.println("Затем введите первое число и нажмите <Enter>:");
        System.out.println("После этого введите второе число и нажмите <Enter>:");
    }

    @Override
    public void fillMenu() {
        menu.add("0. Сложить.");
        menu.add("1. Вычесть.");
        menu.add("2. Умножить.");
        menu.add("3. Делить.");
        menu.add("4. Повторить последнее действие.");
        menu.add("5. Выход из программы");
    }


    /**
     * Показать меню.
     */
    @Override
    public void showMenu() {
        fillMenu();
        info();
        for (String point : menu) {
            System.out.println(point);
        }
    }

    public void nextShowMenu() {
        for (String point : menu) {
            System.out.println(point);
        }
    }
}
