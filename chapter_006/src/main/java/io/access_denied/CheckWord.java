package io.access_denied;

import java.io.*;
import java.util.Arrays;

/**
 * Задача.
 * задан символьным поток. и символьный выходной поток. надо удалить все слова abuse.
 * Важно все преобразования нужно делать в потоке. нельзя зачитать весь поток в память,
 * удалить слова и потом записать. нужно все делать в потоке.
 */

/**
 * @author Marat Zainullin
 * version 1.0
 * @since 30.12.2018
 */
public class CheckWord {

    private String pathIn = "";
    private String pathOut = "";

    StringBuilder sb = new StringBuilder();

    public String getPathIn() {
        return pathIn;
    }
    public void setPathIn(String pathIn) {
        this.pathIn = pathIn;
    }
    public String getPathOut() {
        return pathOut;
    }
    public void setPathOut(String pathOut) {
        this.pathOut = pathOut;
    }


    /**
     * Метод удаления слов из текста.
     * @param in - входящий поток байтов
     * @param out - исходящий поток байтов
     * @param abuse - массив слов
     * @throws IOException - метод может бросить ошибку ввода/вывода
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {

        in = new FileInputStream(getPathIn());
        out = new FileOutputStream(getPathOut());

        String line = "";

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                PrintStream outp = new PrintStream(out);
                ) {

                while ((line = reader.readLine()) != null) {
                    for (String words : abuse) {
                        if (line.contains(words)) {
                            line = line.replaceAll(words, "");
                        }
                    }
                    outp.println(line);
                }

        } catch (IOException e) {
            System.err.println("Ошибка файла: " + e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        CheckWord checkWord = new CheckWord();

        checkWord.setPathIn("D:\\project\\mzainullin\\chapter_006\\src\\main\\java\\io\\access_denied\\input.txt");
        checkWord.setPathOut("D:\\project\\mzainullin\\chapter_006\\src\\main\\java\\io\\access_denied\\output.txt");

        String[] str = {"Lorem", "Ipsum", ",", "type"};

        checkWord.dropAbuses(
                new FileInputStream(new File(checkWord.getPathIn())),
                new FileOutputStream(new File(checkWord.getPathOut())),
                str);
    }

}

