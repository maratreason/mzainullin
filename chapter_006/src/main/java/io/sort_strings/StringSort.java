package io.sort_strings;

import java.io.*;
import java.util.*;

/**
 * @author Marat Zainullin
 * @since 02.01.2018
 */
public class StringSort implements InputSort {

    private String path;
    ArrayList<String> list = new ArrayList<>();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void sort(File source, File distance) {
        source = new File(getPath());

        StringBuilder sb = new StringBuilder();
        String inpString = "";

        if (!distance.exists()) {
            distance = new File("D:\\project\\mzainullin\\chapter_006\\src\\main\\java\\io\\sort_strings\\distance.txt");
        }

        try (FileInputStream is = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(distance)) {

            int text = 0;

            while ((text = is.read()) != -1) {
                sb.append((char) text);
                inpString = new String(sb);
            }

            // Разбить строку построчно
            String[] lines = inpString.split("\n");

            System.out.println("Вывод массива");
            for (String a : lines) {
                System.out.println(a);
                list.add(a);
            }

            System.out.println("\nВывод массива после сортировки");

            // От маленького к большему
            ArrayList<String> newArrList = new ArrayList<>();
            while(!list.isEmpty()) {
                String bigger = "";
                String less = "";
                for(String word : list) {
                    if(word.length() > bigger.length()) {
                        bigger = word;
                    }
                }

                while(list.contains(bigger)) {
                    list.remove(bigger);
                    newArrList.add(bigger);
                }
            }

            System.out.println("---До сортировки по длине---");
            for (String a : newArrList) {
                System.out.println(a);
            }

            Collections.reverse(newArrList);

            System.out.println("\n---После сортировки по длине---");
            for (String a : newArrList) {
                fos.write(a.getBytes());
                System.out.println(a);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws FileNotFoundException {

        StringSort strSort = new StringSort();
        strSort.setPath("D:\\project\\mzainullin\\chapter_006\\src\\main\\java\\io\\sort_strings\\file.txt");

        strSort.sort(new File(strSort.getPath()),
                new File("D:\\project\\mzainullin\\chapter_006\\src\\main\\java\\io\\sort_strings\\distance.txt")
        );
    }
}

/**
 *
 * Необходимо отсортировать файл по возрастанию длин строк,
 * использовать внешнюю сортировку и RandomAccessFile.
 */