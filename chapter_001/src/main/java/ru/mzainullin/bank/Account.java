package ru.mzainullin.bank;

/**
 * @author Marat Zainulin
 * @version 1.0
 * @sicne 15.05.2018
 */
public class Account {
    private double value;
    private String requisites;

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;

    }

    public String getRequisites() {
        return requisites;
    }

    public Account(){}

    public Account(double value, String req) {
        this.requisites = req;
        this.value = value;
    }

    public boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.value && destination != null) {
            success = true;
            this.value -= amount;
            destination.value += amount;
        }
        return success;
    }

    @Override
    public String toString() {
        return "Account{" +
                "value='" + value + '\'' +
                ", requisites='" + requisites + '\'' +
                '}';
    }
}
