package io.sort_strings;

import java.io.File;

/**
 * @author Marat Zainullin
 * @since 02.01.2018
 */
public interface InputSort {

    /**
     * Метод сортировки строк.
     * @param source - Входящий файл со строками
     * @param distance - Новый файл. В него надо записать результат сортировки
     */
    void sort(File source, File distance);

}
