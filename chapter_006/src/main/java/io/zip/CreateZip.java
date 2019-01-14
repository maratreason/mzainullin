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

    /**
     * Список расширений.
     */
    private final List<String> extensions;

    public CreateZip(final List<String> extensions) {
        this.extensions = extensions;
    }


    /**
     * Метод создания архива.
     * @param sourceFile файлы для архивации.
     * @param path директория.
     * @param zos архив.
     * @throws IOException
     */
    private void writetoZip(File sourceFile, String path, ZipOutputStream zos) throws IOException {
        FileInputStream fis = new FileInputStream(sourceFile);
        ZipEntry entry = new ZipEntry(path);

        zos.putNextEntry(entry);

        final byte[] buffer = new byte[1024];
        int len;

        while((len = fis.read(buffer)) != -1) {
            zos.write(buffer, 0, len);
        }

        fis.close();
    }


    /**
     * Метод архивации разных файлов и директорий.
     * @param extension лист с расширениями файлов.
     * @param toZip файл для архивации.
     * @param path путь файла.
     * @param zos архив.
     * @throws IOException метод может выбросить исключение.
     */
    private void fetchFileToZip(List<String> extension, File toZip, String path, ZipOutputStream zos) throws IOException {
        if (toZip.isDirectory()) {
            zos.setLevel(9);
            File[] files = toZip.listFiles();

            for (File fileName : files) {
                String fileExt = FilenameUtils.getExtension(fileName.getName());
                System.out.println(fileExt);
                for (String ext : extension) {
                    if (fileExt.equals(ext)) {
                        fetchFileToZip(extension, fileName, path + "/" + fileName.getName(), zos);
                    }
                }
            }

            addDirectory(toZip);
        } else {
            writetoZip(toZip, path, zos);

        }
    }


    /**
     * Добавление директории.
     * @param fileSource файл.
     * @throws IOException метод может выбросить исключение.
     */
    private void addDirectory(File fileSource) throws IOException {
        File[] files = fileSource.listFiles();
        System.out.println("Добавление директории <" + fileSource.getName() + ">");
        for(File file : files) {
            if (file.isDirectory()) {
                addDirectory(file);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        List<String> ext = new ArrayList<>();
        ext.add("txt");
        ext.add("html");
        ext.add("json");
        ext.add("jpg");

        CreateZip zip = new CreateZip(ext);
        String path = "D:\\projToZip";
        File sourceFile = new File(path);
        FileOutputStream fos = new FileOutputStream("D:\\newCom.zip");
        ZipOutputStream zos = new ZipOutputStream(fos);

        zip.fetchFileToZip(ext, sourceFile, path, zos);

        zos.close();
        fos.close();
    }


}
