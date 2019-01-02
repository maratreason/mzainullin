package io.sort_strings;

import java.io.*;
import java.util.*;

/**
 * @author Marat Zainullin
 * @since 02.01.2018
 */
public class StringSort implements InputSort {

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    Set<String> someSet = new TreeSet<>();

    /**
     * Временный метод сортировки строк.
     * @return - отсортированный TreeSet
     * @throws FileNotFoundException
     */
    public Set<String> prepare() throws FileNotFoundException {
        Scanner scan = new Scanner(new File(getPath()));

        TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.length() - o2.length()) >= 0 ? 1 : -1;
            }
        });

        while (scan.hasNext()) {
            set.add(scan.nextLine());
        }
        scan.close();

        return set;
    }


    @Override
    public void sort(File source, File distance) {
        source = new File(getPath());
        StringBuilder sb = new StringBuilder();

        if (!distance.exists()) {
            distance = new File("D:\\project\\mzainullin\\chapter_006\\src\\main\\java\\io\\sort_strings\\distance.txt");
        }

        try (FileInputStream is = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(distance)) {

            int text = 0;
            while ((text = is.read()) != -1) {
                sb.append((char) text);
                char someText = (char) text;
//                someSet.add(String.valueOf(someText));
                someSet.add(String.valueOf(sb));
            }

            for (String anArrStr : someSet) {
                prepare();
                System.out.print(anArrStr);
                fos.write(anArrStr.getBytes());
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