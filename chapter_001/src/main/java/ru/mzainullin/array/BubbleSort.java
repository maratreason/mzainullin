package ru.mzainullin.array;

/**
 * @author Marat Zainullin.
 * @version 1.0
 * @since 0.1
 */
public class BubbleSort {

    /**
     * Метод сортировки пузырьком.
     * @param array = входной параметр
     * @return отсортированный массив.
     */
    public int[] sort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;

    }

}
