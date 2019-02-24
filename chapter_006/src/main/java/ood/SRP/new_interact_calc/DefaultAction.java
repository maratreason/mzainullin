package ood.SRP.new_interact_calc;

/**
 * @author Marat Zainullin.
 * @version 0.1.
 * @since 24.02.2019.
 */
public class DefaultAction implements Menu {

    /**
     * Текстовая инструкция при запуске.
     */
    @Override
    public void info() {
        System.out.println("Выберете один из пунктов (0-5):");
        System.out.println("Затем введите первое число и нажмите <Enter>:");
        System.out.println("После этого введите второе число и нажмите <Enter>:");
    }

    /**
     * Показать меню.
     */
    @Override
    public void showMenu() {
        String[] menu = {"0. Сложить.", "1. Вычесть.", "2. Умножить.", "3. Делить.", "4. Повторить последнее действие.", "5. Выход из программы"};
        info();
        for (String point : menu) {
            System.out.println(point);
        }
    }
}
