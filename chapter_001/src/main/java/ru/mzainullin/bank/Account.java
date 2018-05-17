package ru.mzainullin.bank;

/**
 * @author Marat Zainulin
 * @version 1.0
 * @sicne 15.05.2018
 */
public class Account {
    private String value;
    private String requisites;

    public String getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public Account(){}

    public Account(String value, String req) {
        this.requisites = req;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Account{" +
                "value='" + value + '\'' +
                ", requisites='" + requisites + '\'' +
                '}';
    }
}
