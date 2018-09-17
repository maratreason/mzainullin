package ru.mzainullin.testsql.magnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XmlUsage {

    List<Entry> entryValues = new ArrayList<>();


    @XmlRootElement
    public static class Entry {

        private List<Field> values;

        public Entry() {}

        public Entry(List<Field> values) {
            this.values = values;
        }

        public List<Field> getValues() {
            return values;
        }

        public void setValues(List<Field> values) {
            this.values = values;
        }
    }

    @XmlRootElement
    public static class Field {
        private int value;

        public Field() {}

        public Field(int value) {
            this.value = value;
        }

        public Field(StoreSQL store) {
            store = new StoreSQL();
            store.getFields();
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public void startUsage() throws JAXBException {
        StoreSQL storeSQL = new StoreSQL();
        storeSQL.configSQL();

        StoreXML storeXML = new StoreXML(new File(
                "d:\\Projects\\mzainullin\\chapter_004\\src\\main\\java\\ru\\mzainullin\\testsql\\magnit\\file.xml"
        ));

        Entry entry = new Entry();

        JAXBContext jaxbContext = JAXBContext.newInstance(Entry.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(
                new Entry(Arrays.asList(new Field(storeSQL.getFields()), new Field(storeSQL.getFields()))),
                System.out
        );
    }
}