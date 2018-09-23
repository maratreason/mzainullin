package ru.mzainullin.testsql.magnit.services.xml;

import ru.mzainullin.testsql.magnit.model.Entry;
import ru.mzainullin.testsql.magnit.services.sql.SQLService;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Author Marat Zainullin
 * @version 1.0
 * @since 23.09.2018
 */
public class XMLService {


    public void StaxWriteExample() {
        SQLService store = new SQLService();

        List<Entry> entryValues = store.getLists();

        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(
                    new FileWriter("chapter_004/src/main/java/ru/mzainullin/testsql/magnit/files/inputXML.xml"));

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


    /**
     * Author Marat Zainullin
     * @version 1.0
     * @since 23.09.2018
     */
    public static class ConvertXSQT {

        /**
         * Метод преобразования xml по схеме xslt.
         * @param inputFile исходный xml
         * @param outputFile выходной xml
         * @param xsl схема
         */
        public void convert(File inputFile, File xsl, File outputFile) {
            Source xmlInput = new StreamSource(inputFile);
            Source xslFile = new StreamSource(xsl);
            createFile(outputFile.getPath());
            Result xmlOutput = new StreamResult(outputFile);
            try {
                Transformer transformer = TransformerFactory.newInstance().newTransformer(xslFile);
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformer.transform(xmlInput, xmlOutput);
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        }

        /**
         * Метод создания нового xml-файла
         * @param path - путь к новому файлу.
         */
        public void createFile(String path) {
            File xml = new File(path);
            try {
                boolean created = xml.createNewFile();
                if (created) {
                    System.out.println(String.format("Файл %s создан.", path));
                } else {
                    System.out.println(String.format("Файл %s уже существует и будет перезаписан.", path));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void fileConvertXSQT() throws Exception {
        File inputXML = new File("D:\\Projects\\mzainullin\\chapter_004\\src\\main\\java\\ru\\mzainullin\\testsql\\magnit\\files\\inputXML.xml");
        File dest = new File("D:\\Projects\\mzainullin\\chapter_004\\src\\main\\java\\ru\\mzainullin\\testsql\\magnit\\files\\newXML.xml");
        File schema = new File("D:\\Projects\\mzainullin\\chapter_004\\src\\main\\java\\ru\\mzainullin\\testsql\\magnit\\files\\scheme.xsl");
        new XMLService.ConvertXSQT().convert(inputXML, schema, dest);
    }
}
