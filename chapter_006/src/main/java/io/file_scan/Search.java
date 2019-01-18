package io.file_scan;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Search {


    /**
     * Метод возвращает список всех файлов с конкретным расширение.
     * @param parent путь до каталога с которого нужно осуществлять поиск.
     * @param exts расширение.
     * @return список файлов с указанным расширением.
     */
    List<File> files(String parent, List<String> exts) throws IOException {
        List<File> result = new ArrayList<>();
        File file = new File(parent);

        if (file.isDirectory()) {
            File[] currentFiles = file.listFiles();

            for (File fileName : currentFiles) {
                if (fileName.isDirectory()) {
                    searchDirectory(fileName, exts);
                } else {
                    File tempfile = new File(parent);
                    String fileExt = FilenameUtils.getExtension(fileName.getName());
                    if (tempfile.isDirectory()) {
                        searchDirectory(tempfile, exts);
                    } else {
                        for (String ext : exts) {
                            if (fileExt.equals(ext)) {
                                System.out.println(tempfile);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }


    /**
     * Добавление директории.
     * @param fileSource файл.
     */
    private void searchDirectory(File fileSource, List<String> exts) {
        File[] files = fileSource.listFiles();
        System.out.println("Внутри директории <" + fileSource.getName() + ">");

        for(File file : files) {
            if (file.isDirectory()) {
                System.out.println(" - Директория <" + file.getName() + ">");
            } else {
                String fileExt = FilenameUtils.getExtension(file.getName());
                for (String ext : exts) {
                    if (fileExt.equals(ext)) {
                        System.out.println(" - Файл <" + file.getName() + ">");
                    }
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {
        String path = "D:\\project\\mzainullin\\chapter_006\\src\\main\\java\\io\\file_scan\\source";
        List<String> exts = new ArrayList<>();
        exts.add("txt");
        exts.add("html");
        exts.add("json");
        exts.add("jpg");

        Search search = new Search();
        search.files(path, exts);

    }
}
