package ru.mzainullin.array;

/**
 * @author MaratZainullin
 * @version 1.0
 * @since 0.1
 */
public class Turn {

    /**
     * Метод делает реверс массива.
     * @param array - входной параметр
     * @return перевернутый массив.
     */
    public int[] back(int[] array) {

        if (array == null || array.length <= 1) {
            return null;
        }

        for (int i = 0; i < array.length / 2; i++) {

            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        /* for(int i = 1; i <= array.length; i++) {
                System.out.println(array[array.length - i]);
            }*/

        return array;
    }

   /* public static void main(String[] args) {
        int[] numbers = {3, 5, 6, 2, 1, 7, 8, 9};

        Turn turn = new Turn();
        int[] result = turn.back(numbers);

    }*/

}
