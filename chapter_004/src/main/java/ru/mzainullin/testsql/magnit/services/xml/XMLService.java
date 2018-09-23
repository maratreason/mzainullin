package ru.mzainullin.testsql.magnit.services.xml;

import org.xml.sax.SAXException;
import ru.mzainullin.testsql.magnit.model.Entry;
import ru.mzainullin.testsql.magnit.services.sql.SQLService;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
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


    public void countSumm() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();

        File file = new File("D:\\Projects\\mzainullin\\chapter_004\\src\\main\\java\\ru\\mzainullin\\testsql\\magnit\\files\\newXML.xml");

        if (file.exists()) {
            parser.parse(file, handler);
        }

        System.out.println(String.format("%s %d", "Сумма значений поля field: ", handler.getNum()));

    }


    /*public void TransformSumm() throws Exception {
        String xsl = "<?xml version=\"1.0\"?>\n" +
                "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n" +
                "<xsl:template match=\"/\">\n" +
                "<entries>" +
                "   <xsl:for-each select=\"entries/values\">\n" +
                "       <field>" +
                "           <xsl:value-of select=\"value\"/>" +
                "       </field>\n" +
                "   </xsl:for-each>\n" +
                " </entries>\n" +
                "</xsl:template>\n" +
                "</xsl:stylesheet>\n";

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<entries>\n" +
                " <values>\n" +
                " <value>" + summFields() + "</value>\n" +
                " </values>\n" +
                "</entries>";

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource(
                        new ByteArrayInputStream(xsl.getBytes()))
        );
        transformer.transform(new StreamSource(
                        new ByteArrayInputStream(xml.getBytes())),
                new StreamResult(System.out)
        );
    }*/
}
