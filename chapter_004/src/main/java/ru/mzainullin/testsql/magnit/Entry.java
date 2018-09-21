package ru.mzainullin.testsql.magnit;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

import static ru.mzainullin.testsql.magnit.XmlUsage.*;

@XmlRootElement
public class Entry {

    private int field;

    public Entry() {}

    public Entry(int field) {
        this.field = field;
    }

    @XmlElement
    public int getField() {
        return field;
    }

    @XmlElement
    public void setField(int field) {
        this.field = field;
    }

    private List<Field> values;

    public Entry(List<Field> values) {
        this.values = values;
    }

    @XmlElement
    public List<Field> getListValues() {
        return values;
    }

    @XmlElement
    public void setListValues(List<Field> values) {
        this.values = values;
    }
}
