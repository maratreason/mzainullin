package ru.mzainullin.testsql.magnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 01.09.2018
 */
public class StoreXML {
    public static void main(String[] args) {
        StoreSQL store = new StoreSQL();
        Entry entry = new Entry();
        for (int index = 0; index < store.fields.size(); index++) {
            entry.setField(store.fields.get(index).getField());
        }

        try {
            File file = new File(
                    "d:\\Projects\\mzainullin\\chapter_004\\src\\main\\java\\ru\\mzainullin\\testsql\\xmltraining\\file.xml"
            );

            JAXBContext jaxbContext = JAXBContext.newInstance(Entry.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(entry.getField(), file);
            jaxbMarshaller.marshal(entry.getField(), System.out);
        } catch(JAXBException e) {
            e.printStackTrace();
        }
    }
}