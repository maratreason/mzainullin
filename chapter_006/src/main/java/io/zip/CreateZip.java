package io.zip;

import io.examplesFromBook.zip_example_india.lesson_01.lesson_03.ZipFolderDemo;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Marat Zainullin.
 * @since 03.01.2018.
 */
public class CreateZip {

    private List<String> extensions;

    public List<String> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<String> extensions) {
        this.extensions = extensions;
    }

    public CreateZip(List<String> extensions) {
        this.extensions = extensions;
    }

    private void writetoZip(File sourceFile, String path, ZipOutputStream zos) throws IOException {
        FileInputStream fis = new FileInputStream(sourceFile);
        ZipEntry entry = new ZipEntry(path);

        String ext1 = FilenameUtils.getExtension(entry.getName()); // returns "txt"

//        if (getExt().equals(ext1)) {
//            zos.putNextEntry(entry);
//        }

        zos.putNextEntry(entry);

        final byte[] buffer = new byte[1024];
        int len;

        while((len = fis.read(buffer)) != -1) {
            zos.write(buffer, 0, len);
        }

        fis.close();
    }

    private void fetchFileToZip(File toZip, String path, ZipOutputStream zos) throws IOException {
        if (toZip.isDirectory()) {
            File[] files = toZip.listFiles();
            for (File fileName : files) {
                fetchFileToZip(fileName, path + "/" + fileName.getName(), zos);
            }
        } else {
            writetoZip(toZip, path, zos);
        }
    }

    private String getExt() {
        extensions = new ArrayList<>();
        String temp = "";
        for (String ext : extensions) {
            temp = ext;
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        List<String> ext = new ArrayList<>();
        ext.add("txt");
        ext.add("html");
        ext.add("json");
        CreateZip zip = new CreateZip(ext);
        String path = "D:\\projToZip";
        File sourceFile = new File(path);
        FileOutputStream fos = new FileOutputStream("D:\\newCom.zip");
        ZipOutputStream zos = new ZipOutputStream(fos);
        zip.fetchFileToZip(sourceFile, path, zos);
        zos.close();
        fos.close();
    }


}
