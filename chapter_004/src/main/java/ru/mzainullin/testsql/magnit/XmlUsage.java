package ru.mzainullin.testsql.magnit;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import javax.xml.bind.annotation.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Timer;

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


    public void addToXML() {

        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("chapter_004/src/main/java/ru/mzainullin/testsql/magnit/file.xml");

            // Вызываем метод для добавления новой книги
            addNewValues(document);

        } catch (ParserConfigurationException e) {
            e.printStackTrace(System.out);
        } catch (SAXException se) {
            se.printStackTrace(System.out);
        } catch (IOException ioe) {
            ioe.printStackTrace(System.out);
        }
    }

    private static void addNewValues(Document document) {

        StoreSQL store = new StoreSQL();
        store.configSQL();
        List<Entry> entryValues = store.getLists();

        // Получаем корневой элемент
        Node root = document.getDocumentElement();

        Element values = document.createElement("values");
        Element value = document.createElement("value");

        for (int i = 0; i < entryValues.size(); i++) {
            value.setTextContent(String.valueOf(entryValues.get(i).getField()));
            System.out.println(value.getTextContent());
            values.appendChild(value);
            root.appendChild(values);
            writeDocument(document);
        }

    }

    /**
     * Функция для сохранения DOM в файл
     */
    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        try {
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream("chapter_004/src/main/java/ru/mzainullin/testsql/magnit/file.xml"));
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }

}