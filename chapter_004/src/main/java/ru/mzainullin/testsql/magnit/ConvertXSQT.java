package ru.mzainullin.testsql.magnit;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Author Marat Zainullin
 * @version 1.0
 * @since 23.09.2018
 */
public class ConvertXSQT {

    /**
     * Метод читает файл source и преобразовывает его в файл dest за счет XSLT схемы scheme.
     * @param source исходный xml
     * @param dest выходной xml
     * @param scheme схема
     */
    public void convert(File source, File dest, File scheme) throws Exception {
        String xmlScheme = xmlToString(source.getPath(), scheme.getPath());

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(xmlScheme));
        transformer.transform(new StreamSource(dest.getPath()), new StreamResult(System.out));
    }

    private String xmlToString(String xmlFile, String xslFile) throws Exception {
        // Открыть файлы в виде потоков
        InputStream xml = new FileInputStream(xmlFile);
        InputStream xsl = new FileInputStream(xslFile);
        // Сщоздать источник для транформации из потоков
        StreamSource xmlSource = new StreamSource(xml);
        StreamSource stylesource = new StreamSource(xsl);

        // Создать байтовый поток для результата
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // СОздать приемноик для результатат из байтового потока
        StreamResult xmlOutput = new StreamResult(bos);
        // Создать трансформатор и выполнить трансформацию
        Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
        transformer.transform(xmlSource, xmlOutput);

        // вернуть результат в виде строки
        return bos.toString();
    }

}
