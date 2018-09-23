package ru.mzainullin.testsql.magnit;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Stylizer {

    public static void main (String args[]) throws TransformerException {

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource(
                        new File("D:\\Projects\\mzainullin\\chapter_004\\src\\main\\java\\ru\\mzainullin\\testsql\\magnit\\file.xsl")
        ));
        transformer.transform(new StreamSource(
                new File ("D:\\Projects\\mzainullin\\chapter_004\\src\\main\\java\\ru\\mzainullin\\testsql\\magnit\\file.xml")),
                new StreamResult(System.out)
        );
    }
}

