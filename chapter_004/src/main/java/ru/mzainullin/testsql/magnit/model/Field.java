package ru.mzainullin.testsql.magnit.model;

import ru.mzainullin.testsql.magnit.services.sql.SQLService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Field {
    private int value;

    public Field() {}

    public Field(int value) {
        this.value = value;
    }

    public Field(SQLService store) {
        store = new SQLService();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
