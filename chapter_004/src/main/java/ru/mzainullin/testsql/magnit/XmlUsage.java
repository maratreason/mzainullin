package ru.mzainullin.testsql.magnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

public class XmlUsage {

    @XmlRootElement
    public static class User {
        private List<Field> values;

        public User() {
        }

        public User(List<Field> values) {
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

        public Field() {
        }

        public Field(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) throws Exception {

        StoreSQL store = new StoreSQL();
        store.configSQL();
        store.getFields();

        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        for(int i = 0; i != store.fields.size(); i++) {
            System.out.println(store.fields.size());
            jaxbMarshaller.marshal(
                    new User(Arrays.asList(new Field(store.fields.get(i).getField()))),
                    System.out
            );
        }

        System.out.println(store.fields.size());

    }
}