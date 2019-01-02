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

    private String separator = File.separator;
    StringBuilder sb = new StringBuilder();
    String s = "";

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
     * Метод поииска слов в строке
     * @param line - строка
     * @param reg - слово, которое ищем
     * @return - true / false
     */
    public static boolean foo (String line, String reg) {
        String[] strings = line.split(" "); // делим строку на отдельные слова
        for (String word : strings) {
            if (word.matches(reg)) {  // проверяем в цикле каждое отдельное слово
                return true;
            }
        }
        return false;
    }


    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {

        try (
                InputStream inp = new FileInputStream(getPathIn());
                OutputStream outp = new FileOutputStream(getPathOut());
                ) {

            int data = 0;
            String newStr = "";

            while (data != -1) {
                sb.append((char) data); // lorem...
                data = inp.read();

                s = new String(sb);

                for (int i = 0; i < abuse.length; i++) {
                    String word = abuse[i];
                    // Почему-то всегда меняется только одно слово. Последнее в массиве.
                    newStr = s.replace(word, "");
                    break;
                }
                outp.write(data);
            }
            System.out.println(newStr);

        } catch (IOException e) {
            System.err.println("Ошибка файла: " + e);
        }

    }

    public static void main(String[] args) throws IOException {

        CheckWord checkWord = new CheckWord();
        checkWord.setPathIn("D:\\project\\mzainullin\\chapter_006\\src\\main\\java\\io\\access_denied\\input.txt");
        checkWord.setPathOut("D:\\project\\mzainullin\\chapter_006\\src\\main\\java\\io\\access_denied\\output.txt");

        String[] str = {"Lorem", "Ipsum"};

        checkWord.dropAbuses(
                new FileInputStream(new File(checkWord.getPathIn())),
                new FileOutputStream(new File(checkWord.getPathOut())),
                str);
    }

}

