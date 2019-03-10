package ood.SRP.new_interact_calc;

/**
 * @author Marat Zainullin.
 * @version 0.1.
 * @since 24.02.2019.
 */
public interface CalcActions {

    /**
     * Сложение.
     * @param first First.
     * @param second Second.
     */
    double add(double first, double second);

    /**
     * Вычитание.
     * @param first первый аргумент.
     * @param second второй аргумент.
     */
    double subtract(double first, double second);

    /**
     * Умножение.
     * @param first первый аргумент.
     * @param second второй аргумент.
     */
    double multiple(double first, double second);

    /**
     * Деление.
     * @param first первый аргумент.
     * @param second второй аргумент.
     */
    double divide(double first, double second);
}
