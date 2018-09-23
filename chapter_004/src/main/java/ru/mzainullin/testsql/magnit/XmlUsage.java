package ru.mzainullin.testsql.magnit;

import javax.xml.bind.annotation.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XmlUsage {

    @XmlRootElement
    public static class Field {
        private int value;

        public Field() {}

        public Field(int value) {
            this.value = value;
        }

        public Field(StoreSQL store) {
            store = new StoreSQL();
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


    public void StaxWriteExample() {

        StoreSQL store = new StoreSQL();
        store.configSQL();
        List<Entry> entryValues = store.getLists();

        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(
                    new FileWriter("chapter_004/src/main/java/ru/mzainullin/testsql/magnit/file.xml"));

            writer.writeStartDocument("UTF-8","1.0");
            writer.writeStartElement("entries");

            for (int i = 0; i < entryValues.size(); i++) {
                writer.writeStartElement("fields");
                writer.writeStartElement("field");
                writer.writeCharacters(String.valueOf(entryValues.get(i).getField()));
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
        } catch (XMLStreamException | IOException ex) {
            ex.printStackTrace();
        }
    }

}